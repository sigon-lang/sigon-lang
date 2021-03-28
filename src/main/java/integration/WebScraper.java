package integration;

import java.io.IOException;
import java.util.List;

import br.ufsc.ine.agent.context.communication.Actuator;

public class WebScraper extends Actuator{

	@Override
	public void act(List<String> args) {
		System.out.println(args);
		Process process;
		try {
			process = new ProcessBuilder("/home/rr/repositorios/sigon/sigon-lang/resources/web-scraping","-term=\"lg k20\"", "-output=perception.json").start();
			process.waitFor();
			System.out.println(process.exitValue());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
