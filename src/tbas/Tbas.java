package tbas;

import java.util.ArrayList;

public class Tbas {

	public static void main(String[] args) {

		int a = 1;

		ArrayList<Character> tInstructionList = new ArrayList<Character>();
		
		tInstructionList.add('+');
		tInstructionList.add('+');
		tInstructionList.add('+');
		tInstructionList.add('?');
		
		Doer tDoer = new Doer(tInstructionList);
		
		a += 1;

	}

}
