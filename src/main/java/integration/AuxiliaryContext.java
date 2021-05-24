package integration;

import alice.tuprolog.InvalidTheoryException;
import alice.tuprolog.Theory;
import br.ufsc.ine.agent.context.ContextService;

public class AuxiliaryContext implements ContextService{

	@Override
	public Theory getTheory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verify(String fact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void appendFact(String fact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addInitialFact(String fact) throws InvalidTheoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
