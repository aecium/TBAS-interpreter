package tbas;

import java.util.ArrayList;

public class InstructionTape {
	private char[] instructionTape;
	private int instructionPointer;

	public InstructionTape(char[] instructions) {
		this.instructionTape = instructions;
		this.instructionPointer = 0;
	}

	public int getInstructionPointer() {
		return this.instructionPointer;
	}

	public void setInstructionPointer(int instructionPointer) {
		this.instructionPointer = instructionPointer;
	}

	public void clearTape() {
		this.instructionTape = null;
	}

	public void advanceTape() {
		this.instructionPointer += 1;
	}

	public void retreatTape() {
		this.instructionPointer -= 1;
	}

	public char[] getTapeData() {
		return this.instructionTape;
	}

	public char getInstruction() {

		if (instructionPointer > instructionTape.length - 1  || instructionPointer < 0) {
			return 'n';
		} else {
			return this.instructionTape[instructionPointer];
		}
	}

}
