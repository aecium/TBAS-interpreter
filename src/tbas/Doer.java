package tbas;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;

public class Doer {

	private DataTape tDataTape = new DataTape();
	private InstructionTape tInstructionTape;
	private Integer loopAddress = null;
	private int outPutMode = 0;

	Doer(char[] instructions) {
		tInstructionTape = new InstructionTape(instructions);
	}

	public void run() {
		char tInstruction = 'n';

		do {
			tInstruction = tInstructionTape.getInstruction();

			switch (tInstruction) {

			case '+':
				tDataTape.incrementCellData();
				break;
			case '-':
				tDataTape.decrementCellData();
				break;
			case '?':
				outPut();
				break;
			case '=':
				outPutMode = tDataTape.readTape();
				break;
			case '>':
				tDataTape.advanceTape();
				break;
			case '<':
				tDataTape.retreatTape();
				break;
			case '[':
				loopAddress = tInstructionTape.getInstructionPointer();
				break;
			case ']':
				if (loopAddress != null && tDataTape.readTape() != 0) {
					tInstructionTape.jumpTape(loopAddress);
				}
				break;

			}

			tInstructionTape.advanceTape();
		} while (tInstruction != 'n');
		
	}

	private void outPut() {

		switch (outPutMode) {
			case 0:
				System.out.print(tDataTape.readTape());
				break;
			case 1:
				
				break;
			case 2:
				System.out.print((char)(int)tDataTape.readTape());
				break;
				
		}

	}

}
