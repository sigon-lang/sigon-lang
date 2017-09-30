package br.ufsc.ine.agent.flow;

public class DesiresHandler extends ContextHandler {

	@Override
	public void handleRequest(String literal) {
		System.out.println(literal);
	}

}
