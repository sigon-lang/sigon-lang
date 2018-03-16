package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class Head {

    @Getter
    private ContextService context;

    @Getter
    @Setter
    private String clause;

    @Getter
    @Builder.Default
    private boolean not = false;

    public boolean isVariable() {
        return (this.clause!=null && Character.isUpperCase(this.clause.charAt(0)));
    }
}
