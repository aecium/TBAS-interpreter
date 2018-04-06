package tbas;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;

public class Doer {

	private DataTape tDataTape = new DataTape();
	private InstructionTape tInstructionTape;
	private Integer loopAddress = null;

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
				System.out.print((char)(int)tDataTape.readTape());
				break;
			case '=':

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
				if (loopAddress != null && tDataTape.readTape() != 0){
					tInstructionTape.jumpTape(loopAddress);
				}
				break;

			}

			tInstructionTape.advanceTape();

		} while (tInstruction != 'n');

	}

}
