package tbas;

import java.util.ArrayList;

public class Tbas {

	public static void main(String[] args) {
		String tInstructions;
		
		if (args.length > 0) {
			tInstructions = args[0];
		} else {
			tInstructions = "+++[?-]";
		}
		
		System.out.println(tInstructions);
		
		Doer tDoer = new Doer(tInstructions.toCharArray());
			
		tDoer.run();
		System.out.println("");

	}

}
