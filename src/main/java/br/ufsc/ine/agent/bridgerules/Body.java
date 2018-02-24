package br.ufsc.ine.agent.bridgerules;

import alice.tuprolog.*;
import br.ufsc.ine.agent.context.ContextService;
import lombok.Builder;
import lombok.Data;

import java.util.*;

@Builder
@Data
public class Body {

    public static final String END = ".";
    private ContextService context;
    private String clause;
    private String notClause;
    private Body and;
    private Body or;
    private Head head;

    @Builder.Default
    private List<String> variableFacts = new ArrayList<>();

    public boolean verify(){
        try {
            Theory contextTheory = defineBodyTheory();
            Prolog prolog = new Prolog();
            prolog.setTheory(contextTheory);
            SolveInfo solve = prolog.solve(this.toString()+ END);

            if(!head.isVariable()){
                variableFacts.add(head.getClause());
            } else {
                Term solution = solve.getTerm(this.head.getClause().contains(".") ? this.head.getClause().substring(0, this.head.getClause().length() - 1)
                        : this.head.getClause());
                if (solution.toString().contains("|")) {
                    String[] result = solution.toString().substring(1, solution.toString().length() - 1).split("\\|");
                    for (String s : result) {
                        variableFacts.add(s.replaceAll("_([0-9])*", "_") + ".");
                    }
                } else {
                    variableFacts.add(solution.toString().replaceAll("_([0-9])*", "_")+ ".");
                }
            }
            return solve.isSuccess();
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    private Theory defineBodyTheory() throws InvalidTheoryException {
        StringBuilder builder = new StringBuilder();
        String[] contextSplit = context.getTheory().toString().replaceAll("\\n","").replaceAll("_([0-9])*", "_").trim().split("/.");
        for (String s : contextSplit) {
            if(!s.isEmpty())
                builder.append(context.getName()+"("+s.substring(0,s.length()-1)+"). \n");
        }
        Theory contextTheory =new Theory(builder.toString());
        if(this.getAndOrClause().isPresent()) {
            builder = new StringBuilder();
            if(this.and!=null){
                String[] split = and.context.getTheory().toString().replaceAll("\\n","")
                        .replaceAll("_([0-9])*", "_")
                        .trim().split("/.");
                for (String s : split) {
                    if(!s.isEmpty())
                        builder.append(and.context.getName()+"("+s.substring(0,s.length()-1)+"). \n");
                }
            } else if(this.or!=null){
                String[] split = or.context.getTheory().toString().replaceAll("\\n","")
                        .replaceAll("_([0-9])*", "_")

                        .trim().split("/.");
                for (String s : split) {
                    if(!s.isEmpty())
                        builder.append(or.context.getName()+"("+s.substring(0,s.length()-1)+"). \n");
                }
            }
            Theory andOrTheory =  new Theory(builder.toString());
            contextTheory.append(andOrTheory);
        }
        return contextTheory;
    }






    public List<String> getVariableFacts() {
        return Collections.unmodifiableList(variableFacts);
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        if(this.notClause!=null){
            builder.append("\\+");
        }
        builder.append(this.getContextClause());

        if(this.getConnector().isPresent()) {
            String head = replaceFirstOccurrenceOfString(builder.toString(), ".", "");
            builder = new StringBuilder();
            builder.append(head);
            builder.append(replaceFirstOccurrenceOfString(this.getConnector().get(),".", ""));

        }
        return builder.toString();
    }

    public Optional<String> getConnector(){
        //; / ,	logical or / and (short circuit)
        if(this.and!=null){
            return Optional.ofNullable(" , " + this.and);
        } else if(this.or!=null){
            return Optional.ofNullable( " ; " + this.or);
        }
        return Optional.empty();
    }


    public String getContextClause(){

        if (this.clause != null) {
            return this.context.getName() + "("+ this.clause + ")";
        }
        return this.context.getName() + "("+  this.notClause + ")";

    }

    public Optional<String> getAndOrClause(){
        if(this.and!=null){
            return Optional.ofNullable(this.getContextClause());
        } else if(this.or!=null){
            return Optional.ofNullable(this.or.getContextClause());
        }
        return Optional.empty();
    }

    private static String replaceFirstOccurrenceOfString(String inputString, String stringToReplace,
                                                         String stringToReplaceWith) {
        if(!inputString.contains(stringToReplace)){
            return inputString;
        }
        int length = stringToReplace.length();
        int inputLength = inputString.length();

        int startingIndexofTheStringToReplace = inputString.indexOf(stringToReplace);

        String finalString = inputString.substring(0, startingIndexofTheStringToReplace) + stringToReplaceWith
                + inputString.substring(startingIndexofTheStringToReplace + length, inputLength);

        return finalString;

    }

    public void setHead(Head head) {
        this.head = head;
    }
}
