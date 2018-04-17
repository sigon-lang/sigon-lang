package br.ufsc.ine;

import agent.AgentLexer;
import agent.AgentParser;
import br.ufsc.ine.agent.Agent;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.parser.AgentWalker;
import br.ufsc.ine.parser.VerboseListener;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class TestBeliefs {


    @Test
    public void test(){
        try {

            File agentFile = new File("/home/valdir/Documents/agent-app/r1.on");
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




        } catch (IOException e) {
            System.out.println("I/O exception.");
        }
    }


    @Test
    public void test2(){
        BeliefsContextService.getInstance().appendFact("at(P):-pos(P,X,Y)&pos(r1,X,Y).");
    }
}
