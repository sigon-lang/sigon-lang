package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BridgeRule {

    private Head head;
    private Body body;


    public boolean verify(){
        return this.body.verify();
    }

    public void execute(){
        if(this.body.verify()){
            ContextService context = this.head.getContext();
            if(head.isVariable()){
                this.body.getVariableFacts().forEach(context::appendFact);
            } else{
                context.appendFact(head.getClause());
            }
        }
    }
}
