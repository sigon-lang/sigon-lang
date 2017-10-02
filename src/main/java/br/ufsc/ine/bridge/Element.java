package br.ufsc.ine.bridge;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Element {

	private String context;
	private String type;
	private Element and;
	private Element or;
	
	
	
	

}
