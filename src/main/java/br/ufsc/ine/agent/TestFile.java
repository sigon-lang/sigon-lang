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
			CharStream stream = CharStreams.fromFileName("/home/valdirluiz/works/agent-project/ex1");
			AgentLexer lexer = new AgentLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			AgentParser parser = new AgentParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(new VerboseListener());

			ParseTree tree = parser.agent();
			ParseTreeWalker walker = new ParseTreeWalker();

			ContextWalker contextWalker = new ContextWalker();
			walker.walk(contextWalker, tree);

			contextWalker.getContexts().forEach(ctx -> {
				System.out.println("Context: " 
						+ ctx.getName().toString().toLowerCase() 
						+ ", type: " 
						+  ctx.getType().toString().toLowerCase());
				ctx.getClauses().forEach(System.out::println);
			});

		} catch (IOException e) {
			System.out.println("I/O exception.");
		}

	}

}
