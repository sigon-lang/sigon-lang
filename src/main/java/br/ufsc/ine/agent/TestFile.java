package br.ufsc.ine.agent;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import agent.AgentLexer;
import agent.AgentParser;
import br.ufsc.ine.parser.ContextWalker;
import br.ufsc.ine.parser.PlanWalker;
import br.ufsc.ine.parser.VerboseListener;

public class TestFile {

	public static void main(String[] args) {

		try {
			CharStream stream = CharStreams.fromFileName("/home/valdirluiz/works/agent-project/examples/oiMundo");
			AgentLexer lexer = new AgentLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			AgentParser parser = new AgentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(new VerboseListener());

			ParseTree tree = parser.agent();
			ParseTreeWalker walker = new ParseTreeWalker();

			ContextWalker contextWalker = new ContextWalker();
			PlanWalker planWalker = new PlanWalker();
			walker.walk(contextWalker, tree);
			walker.walk(planWalker, tree);
			
			Agent agent = new Agent();
			agent.run(contextWalker, planWalker);

		} catch (IOException e) {
			System.out.println("I/O exception.");
		}

	}

}
