package br.ufsc.ine.agent;

import br.ufsc.ine.agent.context.communication.Actuator;
import br.ufsc.ine.agent.context.flow.BeliefsHandler;
import br.ufsc.ine.agent.context.flow.ContextHandler;
import br.ufsc.ine.agent.context.Context;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.flow.DesiresHandler;
import br.ufsc.ine.agent.context.flow.PlansHandler;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.parser.AgentWalker;
import br.ufsc.ine.agent.context.communication.Sensor;
import rx.Observable;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agent {

    private static final String DESIRES = "desires";
    private static final String BELIEFS = "beliefs";

    private List<Sensor> sensors = new ArrayList<>();
    private List<Actuator> actuators = new ArrayList<>();

    public Agent() {
        BeliefsContextService.startService();
        DesiresContextService.startService();
        IntentionsContextService.startService();

        PlansContextService.startService(this.actuators);





    }

    public void run(AgentWalker walker) {
        this.initAgent(walker);
        //TODO: fazer um metodo para criar a cadeia de forma dinamica, considerar contextos criadas pelo usuario
        ContextHandler beliefsHandler = new BeliefsHandler();
        ContextHandler desiresHandler = new DesiresHandler();
        PlansHandler plansHandler = new PlansHandler();

        beliefsHandler.setSuccessor(desiresHandler);
        desiresHandler.setSuccessor(plansHandler);



        this.subscribeSensors(beliefsHandler);
        this.startSensors();


    }

    private void subscribeSensors(ContextHandler beliefsHandler) {
        List<Observable<String>> observables = this.sensors.stream().map(s -> s.getPublisher()).collect(Collectors.toList());

        observables.forEach(stringObservable -> stringObservable.subscribe(beliefsHandler::handleRequest, Throwable::printStackTrace));
    }

    private void startSensors() {
        this.sensors.stream().forEach(s-> {
            Thread sensorThread = new Thread(s);
            sensorThread.start();
        });
    }

    private void initAgent(AgentWalker walker) {

        List<Context> desires = getContext(walker, DESIRES);
        List<Context> beliefs = getContext(walker, BELIEFS);

        walker.getLangActuators().forEach(a ->{
            try{
                Class<?> clazz = Class.forName(a.getImplementation());
                Constructor<?> ctor = clazz.getConstructor();
                Actuator actuator = (Actuator) ctor.newInstance();
                actuator.setName(a.getIdentifier());
                actuators.add(actuator);
            } catch (Exception e){
                e.printStackTrace();
                //TODO: implementar log
            }
        });

        walker.getLangSensors().stream().map(s -> s.getImplementation()).forEach(implementation -> {
            try{
                Class<?> clazz = Class.forName(implementation);
                Constructor<?> ctor = clazz.getConstructor();
                Sensor sensor = (Sensor) ctor.newInstance();
                sensors.add(sensor);
            } catch (Exception e){
                e.printStackTrace();
                //TODO: implementar log
            }

        });


        BeliefsContextService.getInstance().beliefs(beliefs);
        DesiresContextService.getInstance().desires(desires);
        PlansContextService.getInstance().plans(walker.getPlans());

    }

    private List<Context> getContext(AgentWalker walker, String context) {
        return walker.getContexts().stream().filter(c -> c.getName().equals(context)).collect(Collectors.toList());
    }

    public List<Actuator> getActuators() {
        return actuators;
    }
}
