package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Body {

	private ContextService context;
	private String clause;
	private String notClause;
	private Body and;
	private Body or;

	public boolean verify(){
		boolean isValid;
		ContextService service = context;

		if(this.clause!=null) {
			isValid = service.verify(this.clause);
		} else{
			isValid = !service.verify(this.notClause);
		}

		if(this.and!=null && isValid) {
			isValid = this.and.verify();
		} else if(this.or!=null && isValid) {
			isValid = this.or.verify();
		}
		return isValid;
	}
}
