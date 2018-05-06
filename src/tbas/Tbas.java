package tbas;

import java.util.ArrayList;

public class Tbas {

	public static void main(String[] args) {
		String tInstructions;
		InstructionTape tInstructionTape;
		DataTape tDataTape = new DataTape();
		DataBuffer tDataBuffer = new DataBuffer();
		
		if (args.length > 0) {
			tInstructions = args[0];
		} else {
			tInstructions = "+++[?-]";
		}

		tInstructionTape = new InstructionTape(tInstructions.toCharArray());
		
		TPU tDoer = new TPU(tInstructionTape,tDataTape,tDataBuffer);
		
		String tOutPut = tDoer.run();
		
		System.out.print(tOutPut);

	}

}
