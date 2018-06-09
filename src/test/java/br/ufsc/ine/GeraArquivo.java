package br.ufsc.ine;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.ibm.icu.text.SimpleDateFormat;

public class GeraArquivo {
	
	private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	static long cycles = 0;
	static long uteis =0;
	
	public static void main(String[] args) {
//		try (Stream<String> stream = Files.lines(Paths.get("/home/valdirluiz/Documents/resultado-regras/30-70"))) {
//
//			stream.forEach(line ->{
//				if(line.contains("sense(approaching(car)).")) {
//					uteis++;
//				}
//			});
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(uteis);
		executorService.scheduleWithFixedDelay(approaching(), 0, 10, TimeUnit.MILLISECONDS);
		//executorService.scheduleWithFixedDelay(time(), 0, 30, TimeUnit.MILLISECONDS);
	}
	
	protected static Runnable time() {
		return () -> {
			SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
			String time = sdf.format(new Date());
			addSense("sense(time" + time + ").");
		};
	}

	protected static Runnable approaching() {
		return () -> {
			addSense("sense(approaching(car)).");
		};
	}
	
	private static synchronized void addSense(String sense) {
		cycles++;
		if(cycles==10000) {
			executorService.shutdown();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/valdirluiz/Documents/resultado-regras/100-0", true));
			writer.append(sense + System.lineSeparator());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
