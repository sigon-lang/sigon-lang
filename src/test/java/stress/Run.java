package stress;

import br.ufsc.ine.agent.bridgerules.Body;
import br.ufsc.ine.agent.bridgerules.BridgeRule;
import br.ufsc.ine.agent.bridgerules.Head;
import br.ufsc.ine.agent.context.ContextService;
import br.ufsc.ine.agent.context.beliefs.BeliefsContextService;
import br.ufsc.ine.agent.context.custom.CustomContext;
import br.ufsc.ine.agent.context.desires.DesiresContextService;
import br.ufsc.ine.agent.context.intentions.IntentionsContextService;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Run {


    private static ContextService beliefsContext = BeliefsContextService.getInstance();
    private static ContextService desires = DesiresContextService.getInstance();
    private static ContextService intentions = IntentionsContextService.getInstance();
    private static CustomContext customContext1 = new CustomContext("emotion");
    private static CustomContext customContext2 = new CustomContext("test");
    private static CustomContext customContext3 = new CustomContext("last");
    static  int i = 0;

    public static void main(String args[]) {

        try {
            String fileName = "/home/valdirluiz/resultado-stress/target";

            FileOutputStream fos = new FileOutputStream("/home/valdirluiz/resultado-stress/6_contexto-aleatorio.csv", true);
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                stream.forEach((String t) ->{
                    Random rand = new Random();
                    int n = rand.nextInt((5 - 1) + 1) + 1;
                    if(n == 1) {
                        desires.appendFact(t);
                    } else if(n ==2) {
                        intentions.appendFact(t);
                    } else if(n == 3) {
                        customContext1.appendFact(t);
                    } else if(n ==4) {
                        customContext2.appendFact(t);
                    } else if(n == 5) {
                        customContext3.appendFact(t);
                    }
                    i++;
                    long startTime = System.nanoTime();
                    rule6().execute();
                    long endTime = System.nanoTime();
                    long duration = (endTime - startTime) / 1000000;
                    String result = i+";"+duration+System.lineSeparator();
                    write(fos, result);
                });

            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void write(FileOutputStream fos, String result) {
        try {
            fos.write(result.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getVmParameters(){
        RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
        List<String> arguments = runtimeMxBean.getInputArguments();
        arguments.forEach(System.out::println);
    }

    @Test
    public void testRule2(){
        DesiresContextService.getInstance().appendFact("test.");
        beliefsContext.appendFact("test.");
        rule2().execute();
        System.out.println(beliefsContext.getTheory().toString());
    }



    private static  BridgeRule rule2(){
        Head head = Head.builder().context(beliefsContext).clause("X").build();
        Body not = Body.builder().context(beliefsContext).notClause("X").build();
        Body body =   Body.builder().context(desires).clause("X").and(not).build();


        BridgeRule bridgeRule = BridgeRule.builder().head(head).body(body).build();
        return bridgeRule;
    }

    private static  BridgeRule rule3(){
        Head head = Head.builder().context(beliefsContext).clause("X").build();
        Body not = Body.builder().context(beliefsContext).notClause("X").build();
        Body body2  = Body.builder().context(intentions).clause("X").build();
        Body body =   Body.builder().context(desires).clause("X").and(body2).and(not).build();


        BridgeRule bridgeRule = BridgeRule.builder().head(head).body(body).build();
        return bridgeRule;
    }

    private static  BridgeRule rule4(){
        Head head = Head.builder().context(beliefsContext).clause("X").build();
        Body not = Body.builder().context(beliefsContext).notClause("X").build();
        Body body2  = Body.builder().context(intentions).clause("X").build();
        Body body3  = Body.builder().context(customContext1).clause("X").build();
        Body body =   Body.builder().context(desires).clause("X").and(body2).and(body3).and(not).build();


        BridgeRule bridgeRule = BridgeRule.builder().head(head).body(body).build();
        return bridgeRule;
    }

    private static  BridgeRule rule5(){
        Head head = Head.builder().context(beliefsContext).clause("X").build();
        Body not = Body.builder().context(beliefsContext).notClause("X").build();
        Body body2  = Body.builder().context(intentions).clause("X").build();
        Body body3  = Body.builder().context(customContext1).clause("X").build();
        Body body4  = Body.builder().context(customContext2).clause("X").build();
        Body body =   Body.builder().context(desires).clause("X").and(body2).and(body3).and(body4).and(not).build();


        BridgeRule bridgeRule = BridgeRule.builder().head(head).body(body).build();
        return bridgeRule;
    }

    private static  BridgeRule rule6(){
        Head head = Head.builder().context(beliefsContext).clause("X").build();
        Body not = Body.builder().context(beliefsContext).notClause("X").build();
        Body body2  = Body.builder().context(intentions).clause("X").build();
        Body body3  = Body.builder().context(customContext1).clause("X").build();
        Body body4  = Body.builder().context(customContext2).clause("X").build();
        Body body5  = Body.builder().context(customContext3).clause("X").build();
        Body body =   Body.builder().context(desires).clause("X").and(body2).and(body3).and(body4).and(body5).and(not).build();


        BridgeRule bridgeRule = BridgeRule.builder().head(head).body(body).build();
        return bridgeRule;
    }







}
