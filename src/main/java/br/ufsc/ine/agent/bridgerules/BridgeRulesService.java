package br.ufsc.ine.agent.bridgerules;


import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;


import java.util.ArrayList;
import java.util.List;

public class BridgeRulesService {

    private static final String VARIABLE = "X";
    private static BridgeRulesService ourInstance = new BridgeRulesService();

    BeliefsContextService beliefsContext = BeliefsContextService.getInstance();
    DesiresContextService desiresContext = DesiresContextService.getInstance();
    CommunicationContextService communicationContext = CommunicationContextService.getInstance();
    IntentionsContextService intentionsContext = IntentionsContextService.getInstance();
    PlansContextService plansContext = PlansContextService.getInstance();

    private BridgeRulesService() {

    }

    public static BridgeRulesService getInstance() {
        return ourInstance;
    }

    public List<BridgeRule> bridgeRules(){

/*TODO: refactor between this method and bdiBridgeRules*/
        /*Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
        Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
        Body desires = Body.builder().context(desiresContext).clause("Y").build();
        body.setAnd(planMember);
        plan.setAnd(planMember);
        planMember.setAnd(desires);
        BridgeRule r1 = BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(body)
                .build();
*/
        List<BridgeRule> rules = new ArrayList<BridgeRule>();

        return rules;
    }






    public void executeBdiRules() {

        Body body = Body.builder().context(communicationContext).clause("sense(X)").build();
        Body plan = Body.builder().context(plansContext).clause("plan(Y,_,Z,_)").build();
        Body planMember = Body.builder().context(plansContext).clause("member(X, Z)").build();
        Body desires = Body.builder().context(desiresContext).clause("Y").build();
        body.setAnd(plan);
        plan.setAnd(planMember);
        planMember.setAnd(desires);
         BridgeRule.builder()
                .head(Head.builder().context(beliefsContext).clause("X").build())
                .body(body)
                .build().execute();

 		Body desireIntention = Body.builder().context(desiresContext).clause("X").build();
 		Body notBelief = Body.builder().context(beliefsContext).notClause("X").build();
 		Body planSomethingToBeTrue = Body.builder().context(plansContext).clause("plan(X,_,_,_)").build();
        
 		Body notIntention = Body.builder().context(intentionsContext).notClause("X").build();

 		desireIntention.setAnd(notBelief);
		notBelief.setAnd(planSomethingToBeTrue);
		planSomethingToBeTrue.setAnd(notIntention);
		
 		
 		BridgeRule.builder().head(Head.builder().context(intentionsContext).clause("X").build()).body(desireIntention)
 				.build().execute();

        
         

    }
}
