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
import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Prolog;
import alice.tuprolog.SolveInfo;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.Agent;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.parser.AgentWalker;
import br.ufsc.ine.parser.VerboseListener;



public class MainTrescak{
	
	public static void main(String[] args) throws InterruptedException {
		startAgent();
		Thread.sleep(2000);
		percept();
				
	}
	
	public static void sendPropose(List<String> t) {		
		System.out.println(t);
		//System.out.println(t.get(1)+" "+t.get(0)+" to "+t.get(2)+" the "+t.get(3));
		
	}
	
	private static void startAgent(){
	    try {

	       
	    	//File agentFile = new File("/home/rr/sigon-lang/src/main/java/br/ufsc/ine/negotiation/negotiation_aat.on");
	    	//File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/propose_to_alpha.on");
	    	//File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/cenario2Final.on");
	    	//File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/propose_to_beta_first.on");
	    	//File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/propose_to_beta_firstv2.on");
	    	File agentFile = new File("/home/rodrigor/sigon-lang/src/main/java/br/ufsc/ine/negotiation/cenario2/propose_to_beta_firstv2.on");

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
	        Agent agent = new Agent();	    
	        agent.run(agentWalker, cc);


	    } catch (IOException e) {
	        System.out.println("I/O exception.");
	    }
	}
	
	
	 private static void percept(){
	        //ReadMessage.msg.onNext("askGive(b,a,screw)."); enviado para a na segunda rodada
		 	ReadMessage.msg.onNext("msg");
	  
	        
	     
	        
	        
	        System.out.println("CC "+CommunicationContextService.getInstance().getTheory());
	        System.out.println("BC "+BeliefsContextService.getInstance().getTheory().toString());	
			System.out.println("NC "+NegotiationContextService.getInstance().getTheory());

	        System.out.println("DC " +DesiresContextService.getInstance().getTheory());
	        System.out.println("IC "+IntentionsContextService.getInstance().getTheory());
	        
	        //ReadMessage.msg.onNext("askGive(mi,beta,screwDriver).");

	     

	        
	        
	        

	    }

	


	
}





