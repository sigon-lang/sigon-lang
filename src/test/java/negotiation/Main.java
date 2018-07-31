package negotiation;

import java.util.List;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import agent.AgentLexer;
import agent.AgentParser;
import br.ufsc.ine.agent.Agent;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.communication.CommunicationContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import br.ufsc.ine.agent.context.plans.PlansContextService;
import br.ufsc.ine.parser.AgentWalker;
import br.ufsc.ine.parser.VerboseListener;



public class Main{
	
	public static void main(String[] args) {
		startAgent();
		percept();

		


		
	}
	
	public static void sendPropose(List<String> t) {
		
		for (String string : t) {
			System.out.println(string);
		}
	}
	
	private static void startAgent(){
	    try {

	        File agentFile = new File("/home/rodrigor/negotiation/sigon-lang/examples/test.on");
	        CharStream stream = CharStreams.fromFileName(agentFile.getAbsolutePath());
	        AgentLexer lexer = new AgentLexer(stream);
	        CommonTokenStream tokens = new CommonTokenStream(lexer);

	        AgentParser parser = new AgentParser(tokens);
	        parser.removeErrorListeners();
	        parser.addErrorListener(new VerboseListener());

	        ParseTree tree = parser.agent();
	        ParseTreeWalker walker = new ParseTreeWalker();

	        AgentWalker agentWalker = new AgentWalker();
	        walker.walk(agentWalker, tree);
	        
	        Agent agent = new Agent();	        
	        agent.run(agentWalker);
	       /* System.out.println(BeliefsContextService.getInstance().getTheory());
	        System.out.println(DesiresContextService.getInstance().getTheory());
	        System.out.println(IntentionsContextService.getInstance().getTheory());
	        System.out.println(PlansContextService.getInstance().getTheory());
	        System.out.println(CommunicationContextService.getInstance().getTheory());
	        */
	        
	        




	    } catch (IOException e) {
	        System.out.println("I/O exception.");
	    }
	}
	
	
	 private static void percept(){
	        System.out.println("Percept");

	        //ReadMessage.publish.onNext("readPropose(teste).");
	        ReadMessage.msg.onNext("readPropose(msg).");


	        System.out.println("CC "+CommunicationContextService.getInstance().getTheory());
	        System.out.println("BC "+BeliefsContextService.getInstance().getTheory().toString());	
	        System.out.println("DC " +DesiresContextService.getInstance().getTheory());
	        System.out.println("PC " +PlansContextService.getInstance().getTheory());
	        System.out.println("IC "+IntentionsContextService.getInstance().getTheory());
	        System.out.println("CC " +CommunicationContextService.getInstance().getTheory());

	        
	        

	    }

	


	
}





