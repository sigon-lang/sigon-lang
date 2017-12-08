package br.ufsc.ine.context.flow;

public class DesiresHandler extends ContextHandler {

	@Override
	public void handleRequest(String literal) {

		//TODO: aplicar regras para alterar algo no contexto de desejos ou não
		
		if (super.successor != null) {
			super.successor.handleRequest(literal);
		}
	}

}
