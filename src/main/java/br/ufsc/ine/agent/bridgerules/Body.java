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


            String toTest = this.toString().endsWith(".") ? this.toString() : this.toString()+ END;
            SolveInfo solve = prolog.solve( toTest );

            try{
                if(head!=null && !head.isVariable()){
                    variableFacts.add(head.getClause());
                } else {

                    if(head.getClause().contains("(") && head.getClause().contains(")")){
                        String clauses = head.getClause().substring(head.getClause().indexOf("(")+1, head.getClause().indexOf(")"));
                        String[] split = clauses.trim().split(",");
                        StringBuilder builder = new StringBuilder();
                        for (int i=0;i<split.length;i++){
                            split[i] = split[i].replace(" ", "");
                            if(Character.isUpperCase(split[i].charAt(0))){
                                Term solution = solve.getTerm(split[i].trim());
                                builder.append(solution.toString().replaceAll("_([0-9])*", "_"));
                                
                            } else{
                                builder.append(split[i]);
                            }
                            if(i+1<split.length) {
                                builder.append(",");
                            }
                        }

                        variableFacts.add(head.getClause().substring(0, head.getClause().indexOf("(")+1)+builder+").");
                        return solve.isSuccess();
                    }


                    Term solution = solve.getTerm(this.head.getTerm());
                    if (solution.toString().contains("|")) {
                        String[] result = solution.toString().substring(1, solution.toString().length() - 1).split("\\|");
                        for (String s : result) {
                            String item = s.replaceAll("_([0-9])*", "_") + ".";
                            variableFacts.add(item);
                        }
                    } else {
                        variableFacts.add(solution.toString().replaceAll("_([0-9])*", "_")+ ".");
                    }
                }
            } catch (Exception e){

            }

            return solve.isSuccess();
        }  catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


    private Theory defineBodyTheory() throws InvalidTheoryException {

        StringBuilder builder = new StringBuilder();
        System.out.println(context.getTheory().toString());
        String[] contextSplit = context.getTheory().toString()
                //.replaceAll("_([0-9])*", "_").trim()
                .replaceAll("\\n\\n", "/").replaceAll("_", "")
                .split("/");

        //String contextName = context.getName().replaceAll("_", "");
        String contextName = context.getName();


        for (String s :contextSplit) {
            if (!s.isEmpty()){
                String result = s.replaceAll("_([0-9])*", "_").trim();
                builder.append(contextName + "(" + result.substring(0, result.length() - 1) + "). \n");
            }
        }


        //TODO: nao esta recursivo
        Theory contextTheory =new Theory(builder.toString());
        builder = new StringBuilder();


        addAndOr(builder, this);
        Theory andOrTheory =  new Theory(builder.toString());
        contextTheory.append(andOrTheory);

        return contextTheory;
    }
    
   
    

    private void addAndOr(StringBuilder builder, Body  body) {
        if(body.getAndOrClause().isPresent()) {
        	if (body.and != null) {       
        		String [] split = body.and.context.getTheory().toString()
                        .replaceAll("_([0-9])*", "_")
                        .trim().split("\\.");        		
        		//qual era a necessidade de ser um split pela quebra de linha e não pelo .?
        		
        		/*if(body.and.context.getTheory().toString().contains(":-")) {
        			split = body.and.context.getTheory().toString()
                    .replaceAll("_([0-9])*", "_")
                    .trim().split("\\.");
        		}*/
        		
            	
                
                for (String s : split) {
                    if (!s.isEmpty())
                        builder.append(body.and.context.getName() + "(" + s.substring(0, s.length()) + "). \n");
                }

                if (body.and.getAndOrClause().isPresent()){
                    addAndOr(builder, body.and);
                }

            } else if (body.or != null) {
                String[] split = body.or.context.getTheory().toString().replaceAll("\\n", "")
                        .replaceAll("_([0-9])*", "_")

                        .trim().split("/.");
                for (String s : split) {
                    if (!s.isEmpty())
                        builder.append(body.or.context.getName() + "(" + s.substring(0, s.length() - 1) + "). \n");
                }

                if (body.or.getAndOrClause().isPresent()){
                    addAndOr(builder, body.or);
                }
            }
        }
    }


    public List<String> getVariableFacts() {
        return Collections.unmodifiableList(variableFacts);
    }


    private void getBodyValue(StringBuilder builder, Body body){


        if(body.notClause!=null){
            builder.append("\\+");
        }
        builder.append(getContextClause(body));

        if(body.and !=null || body.or!=null){
            this.getBodyValue(builder, body);
        }


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
            if(this.clause.startsWith("member(")){
                return this.clause+".";
            }

            return this.context.getName() + "("+ this.clause.replace(".", "") + ")";
        }

        return this.context.getName() + "("+  this.notClause.replace(".", "") + ")";

    }

    private String getContextClause(Body body) {

        if (clause != null){
            if (body.clause.startsWith("member(")) {
                return this.clause + ".";
            }

            if (body.clause != null) {
                return body.context.getName() + "(" + body.clause.replace(".", "") + ")";
            }
        }

        return body.context.getName() + "("+  body.notClause.replace(".", "") + ")";

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
