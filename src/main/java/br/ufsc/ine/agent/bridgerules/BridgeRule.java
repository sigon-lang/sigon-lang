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
        this.body.setHead(this.head);
        return this.body.verify();
    }

    public void execute(){
        this.body.setHead(this.head);
        if(this.body.verify()){
            ContextService context = this.head.getContext();
            this.body.getVariableFacts().forEach(context::appendFact);
        }
    }
}
