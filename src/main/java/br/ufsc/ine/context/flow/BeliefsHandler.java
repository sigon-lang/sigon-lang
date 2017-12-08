package br.ufsc.ine.context.flow;

import alice.tuprolog.InvalidTheoryException;
import br.ufsc.ine.context.beliefs.BeliefsContextService;

public class BeliefsHandler extends ContextHandler{

	@Override
	public void handleRequest(String literal) {

		//TODO: ver como tratar erros
		try {
			BeliefsContextService.getInstance().updateBelief(literal);
		} catch (InvalidTheoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (super.successor != null) {
			super.successor.handleRequest(literal);
		}
		
	}

}
