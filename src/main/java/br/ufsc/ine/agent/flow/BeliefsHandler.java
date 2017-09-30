package br.ufsc.ine.agent.flow;

public class BeliefsHandler extends ContextHandler{

	@Override
	public void handleRequest(String literal) {
		 
		System.out.println("Beliefs: " + literal);
		
	}

}
