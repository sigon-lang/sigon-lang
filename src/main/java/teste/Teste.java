package teste;

import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import agent.AgentLexer;
import agent.AgentParser;

public class Teste {
	
	private static final String TESTE = "beliefs(prop): a. a :- b.";

	public static void main(String[] args) {
			 CharStream stream = new ANTLRInputStream(TESTE);
			AgentLexer lexer = new AgentLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream( lexer );
			AgentParser parser = new AgentParser( tokens );
		    ParseTree tree = parser.agent();
		    
		    ParseTreeWalker walker = new ParseTreeWalker();
		    walker.walk( new AgentWalker(), tree );
		
		 
	}
	
	
}
