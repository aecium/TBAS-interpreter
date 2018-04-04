package tbas;

import java.util.ArrayList;

public class InstructionTape {
	private ArrayList<Character> instructionTape;
	private int instructionPointer;
	
	public InstructionTape(){
		instructionTape = new ArrayList<Character>();
		instructionPointer = 0;
	}

	public int getInstructionPointer() {
		return instructionPointer;
	}

	public void setInstructionPointer(int instructionPointer) {
		this.instructionPointer = instructionPointer;
	}

	public void clearTape() {
		instructionTape.clear();
	}

	public void advanceTape() {
		instructionPointer += 1;
	}

	public void retreatTape() {
		instructionPointer -= 1;
	}

	public void jumpTape(int offset) {
		instructionPointer += offset;
	}

	public Character readTape() {
		return instructionTape.get(instructionPointer);
	}

	public ArrayList<Character> getTapeData() {
		return instructionTape;
	}

	public void setTapeData(ArrayList<Character> tapeData) {
		this.instructionTape = tapeData;
	}

	public void loadTape(ArrayList<Character> instructionList) {
		instructionTape.addAll(instructionList);
	}
	
}
