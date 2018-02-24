package br.ufsc.ine.agent.context.communication;

import alice.tuprolog.MalformedGoalException;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.utils.PrologEnvironment;

public class CommunicationContextService implements ContextService{

    private static CommunicationContextService instance = new CommunicationContextService();
    private static PrologEnvironment prologEnvironment;


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
            prologEnvironment = new PrologEnvironment();
            prologEnvironment.appendFact(fact);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getName() {
        return "cc";
    }
}

