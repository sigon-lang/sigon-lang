package br.ufsc.ine.agent.bridgerules;

import br.ufsc.ine.agent.context.ContextService;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@Data
public class Body {

    private ContextService context;
    private String clause;
    private String notClause;
    private Body and;
    private Body or;

    @Builder.Default
    private List<String> variableFacts = new ArrayList<>();

    public boolean verify(){
        boolean isValid;
        if(isVariable()){
            isValid = verifyVar();
        } else {
            isValid = verifyFact();
        }
        return isValid;
    }

    private boolean verifyVar() {
        boolean isValid;
        if(this.or!=null){
            if(this.clause!=null) {
                this.setContextServiceVariables(this.context);
            }
            if(this.or.clause!=null) {
                this.setContextServiceVariables(this.or.context);
            }
        } else if(this.and!=null){
            Stream<String> contextFacts = Arrays.stream(context.getAllFacts().toString().trim().split("/."));
            Stream<String> andFacts = Arrays.stream(and.context.getAllFacts().toString().trim().split("/."));
            if(and.clause!=null && this.clause!=null) {
                List<String> intersect = contextFacts
                        .filter(andFacts.collect(Collectors.toList())::contains)
                        .collect(Collectors.toList());
                this.variableFacts.addAll(intersect);
            } else if(and.notClause!=null){
                this.variableFacts.addAll(
                        contextFacts
                                .filter(f -> {return
                                         !andFacts.collect(Collectors.toList()).contains(f);})
                                .collect(Collectors.toList()));
            } else if(this.notClause!=null){
                this.variableFacts.addAll(
                        andFacts
                                .filter(f -> {return
                                        !contextFacts.collect(Collectors.toList()).contains(f);})
                                .collect(Collectors.toList()));
            }
        } else {
            if(this.clause!=null) {
                this.setContextServiceVariables(this.context);
            }
        }

        isValid = !this.variableFacts.isEmpty();
        return isValid;
    }

    private boolean verifyFact() {
        boolean isValid;ContextService service = context;
        if (this.clause != null) {
            isValid = service.verify(this.clause);
        } else {
            isValid = !service.verify(this.notClause);
        }

        if (this.and != null && isValid) {
            isValid = isValid && this.and.verify();
        } else if (this.or != null && isValid) {
            isValid = isValid || this.or.verify();
        }
        return isValid;
    }

    private void setContextServiceVariables(ContextService context) {
        String[] split = context.getAllFacts().toString().trim().split("/.");
        for (String s : split) {
            this.variableFacts.add(s);
        }
    }

    private boolean isVariable() {
        return (this.clause!=null && Character.isUpperCase(this.clause.charAt(0)))
                || (this.notClause!=null && Character.isUpperCase(this.notClause.charAt(0)));
    }

    public List<String> getVariableFacts() {
        return Collections.unmodifiableList(variableFacts);
    }
}
