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
		
		Doer tDoer = new Doer(tInstructions.toCharArray());

		tDoer.run();
		
		int a = 0;
		a += 1;

	}

}
