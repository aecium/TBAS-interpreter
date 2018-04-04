package tbas;

import java.util.ArrayList;

public class Doer {
	
	private DataTape tDataTape = new DataTape();
	private InstructionTape tInstructionTape = new InstructionTape();
	
	Doer(ArrayList<Character> instructionList){
		
		tInstructionTape.loadTape(instructionList);
		
	}

}
