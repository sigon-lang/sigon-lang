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

        if(this.clause.contains("(") && this.clause.contains(")")){
            String clauses = this.clause.substring(this.clause.indexOf("(")+1, this.clause.indexOf(")"));
            String[] split = clauses.split(",");
            for (int i=0;i<split.length;i++){
                if(Character.isUpperCase(split[i].charAt(0))){
                    return true;
                }
            }
        }

        return (this.clause!=null && Character.isUpperCase(this.clause.charAt(0)));

    }

    public String getTerm(){
            return this.getClause().contains(".") ? this.getClause().substring(0, this.getClause().length() - 1)
                    : this.getClause();
    }


}
