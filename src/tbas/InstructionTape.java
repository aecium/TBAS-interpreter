package tbas;

import java.util.ArrayList;

public class InstructionTape {
	private char[] instructionTape;
	private int instructionPointer;

	public InstructionTape(char[] instructions) {
		instructionTape = instructions;
		instructionPointer = 0;
	}

	public int getInstructionPointer() {
		return instructionPointer;
	}

	public void setInstructionPointer(int instructionPointer) {
		this.instructionPointer = instructionPointer;
	}

	public void clearTape() {
		instructionTape = null;
	}

	public void advanceTape() {
		instructionPointer += 1;
	}

	public void retreatTape() {
		instructionPointer -= 1;
	}

	public void jumpTape(int cellIndex) {
		instructionPointer = cellIndex;
	}

	public Character readTape() {
		return instructionTape[instructionPointer];
	}

	public char[] getTapeData() {
		return instructionTape;
	}

	public char getInstruction() {

		if (instructionPointer > instructionTape.length - 1  || instructionPointer < 0) {
			return 'n';
		} else {
			return instructionTape[instructionPointer];
		}
	}

}
