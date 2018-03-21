package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public String getTerm(){
            return this.getClause().contains(".") ? this.getClause().substring(0, this.getClause().length() - 1)
                    : this.getClause();
    }


}
