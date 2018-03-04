package br.ufsc.ine.agent.context.communication;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.utils.PrologEnvironment;

import java.util.List;

public class CommunicationContextService implements ContextService{

    private static CommunicationContextService instance = new CommunicationContextService();
    private static PrologEnvironment prologEnvironment;
    private List<Actuator> actuators;
    private CommunicationContextService() {
        prologEnvironment = new PrologEnvironment();
    }
    public static CommunicationContextService getInstance() {
        return instance;
    }



    @Override
    public Theory getTheory() {
        return   prologEnvironment.getEngine().getTheory();
    }

    @Override
    public boolean verify(String fact) {
        SolveInfo solveGoal;
        try {
            solveGoal = prologEnvironment.solveGoal(fact);
            return solveGoal.isSuccess();
        } catch (MalformedGoalException e) {
            return false;
        }
    }

    @Override
    public void appendFact(String fact) {
        try{
            if(fact.startsWith("sense")) {
                prologEnvironment = new PrologEnvironment();
                prologEnvironment.appendFact(fact);
            } else {
                String name = fact.substring(0, fact.length() -1);

                Actuator actuator = actuators.stream()
                        .filter(a -> a.getName().equals(name))
                        .findFirst().get();

                //TODO: passar parametros para funcoes
                actuator.act(null);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "cc";
    }

    public void actuators(List<Actuator> actuators) {
        this.actuators = actuators;
    }
}

