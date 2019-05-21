package stress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Prepare {

    static  int i = 0;

    public static void main(String args[]) {

        try {
            String fileName = "/tmp/sigon-lang/examples/stressFile";

            FileOutputStream fos = new FileOutputStream("/home/thiago/resultado-stress/target", true);
            try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

                stream.forEach((String l) ->{
                    i++;
                    if(i<=3000) {
                        write(fos, l+System.lineSeparator());
                    } else{
                        return;
                    }
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

}
