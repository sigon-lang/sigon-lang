package br.ufsc.ine.agent.context;

import br.ufsc.ine.agent.bridgerules.BridgeRule;
import br.ufsc.ine.agent.bridgerules.BridgeRulesService;
import br.ufsc.ine.agent.bridgerules.Head;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Aspect
public class ContextAppendAspect {



    @Around("execution(* br.ufsc.ine.agent.context.*.appendFact(..))")
    public void appendFactAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Optional<Object> fact = Arrays.stream(joinPoint.getArgs()).findFirst();

        List<BridgeRule> rules = BridgeRulesService.getInstance().bridgeRules().stream().filter(f->{
            return f.getHead().isNot() && (f.getHead().getContext().getClass().isInstance(joinPoint.getTarget()));
        }).collect(Collectors.toList());

        boolean block = isBlock(fact, rules);
        if(!block) {
            joinPoint.proceed();
        }

    }

    private boolean isBlock(Optional<Object> fact, List<BridgeRule> rules) {
        boolean block = false;
        if(!rules.isEmpty()){
            for (BridgeRule rule: rules){
                rule.getHead().setClause(fact.get().toString());
                //TODO: verificar como fazer para buscas mais complexas
                //TODO: deixar recursivo para and e or
                if(rule.getBody().getClause()!=null){
                    String clause=  fact.get().toString();
                    clause = clause.substring(0, clause.length()-1);
                    rule.getBody().setClause(clause);
                }
                if(rule.getBody().getNotClause() !=null){
                    String clause=  fact.get().toString();
                    clause = clause.substring(0, clause.length()-1);
                    rule.getBody().setNotClause(clause);
                }
                Head head  = rule.getHead();
                rule.getBody().setHead(head);
                block = rule.verify();
                if(block ){
                    break;
                }
            }
        }
        return block;
    }
}
