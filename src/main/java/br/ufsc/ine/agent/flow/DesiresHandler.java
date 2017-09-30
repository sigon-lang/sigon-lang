package br.ufsc.ine.agent.flow;


public class DesiresHandler extends ContextHandler {


	@Override
	public void handleRequest(String literal) {
		 
		 
		if (super.successor != null) {
			super.successor.handleRequest(literal);
		}
	}

}
