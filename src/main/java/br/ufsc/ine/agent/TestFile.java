package br.ufsc.ine.agent;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import agent.AgentLexer;
import agent.AgentParser;

public class TestFile {

	public static void main(String[] args) {

		try {
			CharStream stream = CharStreams.fromFileName("/home/valdir/Documents/agent-project/examples/ex1");
			AgentLexer lexer = new AgentLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			AgentParser parser = new AgentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(new VerboseListener());

			ParseTree tree = parser.agent();
			ParseTreeWalker walker = new ParseTreeWalker();

			ContextWalker contextWalker = new ContextWalker();
			walker.walk(contextWalker, tree);
			
			Agent agent = new Agent();
			agent.run(contextWalker);

		} catch (IOException e) {
			System.out.println("I/O exception.");
		}

	}

}
