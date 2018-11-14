package br.ufsc.ine.negotiation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import agent.AgentLexer;
import agent.AgentParser;
import alice.util.Sleep;
import br.ufsc.ine.agent.Agent;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.custom.CustomContext;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.parser.AgentWalker;
import br.ufsc.ine.parser.VerboseListener;



public class Main{
	
	public static void main(String[] args) throws InterruptedException {
		startAgent();
		Thread.sleep(2000);

		percept();
				
	}
	
	public static void sendPropose(List<String> t) {
	

		System.out.println(t);

		
	}
	
	private static void startAgent(){
	    try {

	       // File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/negotiation_sample.on");
	        //File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/negotiation.on");
	        //File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/negotiation_aat.on");
	        //File agentFile = new File("/home/rr/sigon-lang/src/main/java/br/ufsc/ine/negotiation/negotiation.on");
	    	//File agentFile = new File("/home/rr/sigon-lang/src/main/java/br/ufsc/ine/negotiation/negotiation_aat.on");
	    	File agentFile = new File("/home/rr/sigon-lang/src/main/java/br/ufsc/ine/negotiation/cenario2_aat.on");
	        CharStream stream = CharStreams.fromFileName(agentFile.getAbsolutePath());
	        AgentLexer lexer = new AgentLexer(stream);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);

	        AgentParser parser = new AgentParser(tokens);
	        parser.removeErrorListeners();
	        parser.addErrorListener(new VerboseListener());

	        ParseTree tree = parser.agent();
	        ParseTreeWalker walker = new ParseTreeWalker();
	        System.out.println(tree.toStringTree(parser));
	        

	        AgentWalker agentWalker = new AgentWalker();
	        walker.walk(agentWalker, tree);
	        
	        NegotiationContextService nc =  NegotiationContextService.getInstance();
	        
	        
	        ContextService[] cc = new ContextService[] {nc};
	        //CustomContext[] cc = new CustomContext[] {nc.};	        
	        Agent agent = new Agent();	    
	        agent.run(agentWalker, cc);
	        //agent.run(agentWalker, new String[] {"_negotiation"});
	        
	        
	        
	        




	    } catch (IOException e) {
	        System.out.println("I/O exception.");
	    }
	}
	
	
	 private static void percept(){
	        System.out.println("Percept");

	       
	       //ReadMessage.msg.onNext("enterAuction(house).");	        
	       // ReadMessage.msg.onNext("jobOffer/(salary(7000, 5000), time(5, 6)).");
	        //ReadMessage.msg.onNext("salaryOptions(7000, 10000, 12000).");
	        
	        /*jobOffer(
			salary(7000, 10000, 12000),
			jobDescription(qa, programmer, teamManager, projectManager),
			car(leased, noLeased, noAgreement),
			pension(0, 10, 20, noAgreement),
			promotion(2, 4, noAgreement),
			workingHours(8, 9, 10)
			)*/
	        
	        ReadMessage.msg.onNext("solveDispute.");
	        
			
	        
	        System.out.println("CC "+CommunicationContextService.getInstance().getTheory());
	        System.out.println("BC "+BeliefsContextService.getInstance().getTheory().toString());	
			System.out.println("NC "+NegotiationContextService.getInstance().getTheory());

	        System.out.println("DC " +DesiresContextService.getInstance().getTheory());
	        System.out.println("PC " +PlansContextService.getInstance().getTheory().toString());
	        System.out.println("IC "+IntentionsContextService.getInstance().getTheory());
	        System.out.println("CC " +CommunicationContextService.getInstance().getTheory());
	        
	        
	        

	    }

	


	
}





