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

    //TODO: add verificacao para por ex p(X,Z) precisa ser tratado como variavel
    public boolean isVariable() {
       // System.out.println(this.clause.substring());
        //return (this.clause!=null && Character.isUpperCase(this.clause.charAt(0)));
        return true;
    }

    public String getTerm(){
            return this.getClause().contains(".") ? this.getClause().substring(0, this.getClause().length() - 1)
                    : this.getClause();
    }


}
