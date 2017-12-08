package br.ufsc.ine.bridge;

import br.ufsc.ine.context.ContextService;
import br.ufsc.ine.context.beliefs.BeliefsContextService;
import br.ufsc.ine.context.desires.DesiresContextService;
import lombok.Builder;
import lombok.Data;


public class Rule {

	private String verify;
	private Element in;

	// TODO: deixar dinamico
	public boolean execute() {
		 

		boolean isValid = true;

		if (in == null) {
			return false;
		}

		return this.verify(this.in, true);
		
		 
	}
	
	//VERIFICAR E MELHORA TRATAMENTO PARA AND E OR E FORMA DE INSTACIAR SERVICE
	private boolean verify(Element in, boolean isValid) {
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

	public Element getIn() {
		return in;
	}

	public void setIn(Element in) {
		this.in = in;
	}
}
