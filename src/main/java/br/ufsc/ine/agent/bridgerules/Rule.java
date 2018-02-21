package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;


public class Rule {

	private String verify;
	private Body in;

	// TODO: deixar dinamico
	public boolean execute() {
		 

		boolean isValid = true;

		if (in == null) {
			return false;
		}

		return this.verify(this.in, true);
		
		 
	}
	
	//VERIFICAR E MELHORA TRATAMENTO PARA AND E OR E FORMA DE INSTACIAR SERVICE
	private boolean verify(Body in, boolean isValid) {
		ContextService service = null;
		if(in.getContext().equals("beliefs")) {
			service = BeliefsContextService.getInstance();
		} else {
			service = DesiresContextService.getInstance();
		}
		
		isValid = service.verify(this.verify);
		
		if(in.getAnd()!=null) {
			if(!isValid) {
				return false;
			}
			isValid = this.verify(in.getAnd(), isValid);
		} else if(in.getOr()!=null) {
			isValid = this.verify(in.getOr(), isValid);
		}
		return isValid;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public Body getIn() {
		return in;
	}

	public void setIn(Body in) {
		this.in = in;
	}
}
