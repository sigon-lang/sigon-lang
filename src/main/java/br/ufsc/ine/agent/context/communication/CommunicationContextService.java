package br.ufsc.ine.agent.context.communication;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.utils.PrologEnvironment;

import java.util.Arrays;
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
            	int i = fact.indexOf("(");
                String name = fact.substring(0, i);
                
                Actuator actuator = actuators.stream()
                        .filter(a -> a.getName().equals(name))
                        .findFirst().get();
                
                String arg = fact.substring(i + 1, fact.length() - 2);                
                String[] args = arg.split(",");
                
             // TODO: 11/07/18 verify this implementation of the passing of the arguments. FELIPE
                actuator.act(Arrays.asList(args));
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

    @Override
    public void addInitialFact(String fact) {

    }
}

