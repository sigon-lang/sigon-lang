package br.ufsc.ine.agent;

import br.ufsc.ine.agent.flow.BeliefsHandler;
import br.ufsc.ine.agent.flow.ContextHandler;
import br.ufsc.ine.context.Context;
import br.ufsc.ine.context.beliefs.BeliefsContextService;
import br.ufsc.ine.context.desires.DesiresContextService;
import br.ufsc.ine.context.intentions.IntentionsContextService;
import br.ufsc.ine.context.plans.PlansContextService;
import br.ufsc.ine.parser.AgentWalker;
import br.ufsc.ine.parser.PlanWalker;
import br.ufsc.ine.sensor.Sensor;
import rx.Observable;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Agent {

    private static final String DESIRES = "desires";
    private static final String BELIEFS = "beliefs";

    private List<Sensor> sensors = new ArrayList<>();

    public Agent() {
        BeliefsContextService.startService();
        DesiresContextService.startService();
        IntentionsContextService.startService();
        PlansContextService.startService();



    }

    public void run(AgentWalker walker, PlanWalker planWalker) {

        this.initAgent(walker, planWalker);


        //TODO: fazer um metodo para criar a cadeia de forma dinamica, considerar contextos criadas pelo usuario
        ContextHandler beliefsHandler = new BeliefsHandler();
        //ContextHandler desiresHandler = new DesiresHandler();
        //PlansHandler plansHandler = new PlansHandler();

        //beliefsHandler.setSuccessor(desiresHandler);
        //desiresHandler.setSuccessor(plansHandler);

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

    private void initAgent(AgentWalker walker, PlanWalker planWalker) {

        List<Context> desires = getContext(walker, DESIRES);
        List<Context> beliefs = getContext(walker, BELIEFS);

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
        PlansContextService.getInstance().plans(planWalker.getPlans());

    }

    private List<Context> getContext(AgentWalker walker, String context) {
        return walker.getContexts().stream().filter(c -> c.getName().equals(context)).collect(Collectors.toList());
    }

}
