package tbas;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//TBAS Processing Unit (TPU)

public class TPU {

	private DataTape tDataTape = new DataTape();
	private InstructionTape tInstructionTape;
	private Integer loopAddress = null;
	private int outPutMode = 0;

	TPU(char[] instructions) {
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
				inPutOutPut();
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

	private void inPutOutPut() {

		switch (outPutMode) {
		case 0: //Serial Console - Decimal Write
			System.out.print(tDataTape.readTape());
			break;
		case 1: //Serial Console - Decimal Read
			scRead(1);
			break;
		case 2: //Serial Console - ASCII Writ
			System.out.print((char) (int) tDataTape.readTape());
			break;
		case 3: //Serial Console - ASCII Read
			scRead(3);
			break;
		case 4: //Serial Modem – ASCII Write
			
			break;
		case 5: //Serial modem – ASCII Read
			
			break;
		case 6: //Buffer Program
			
			break;
		case 7: //Execute Task
			
			break;
		case 8: //Buffer Enqueue
			
			break;
		case 9: //Buffer Dequeue – FILO
			
			break;
		case 10: //Buffer Dequeue – FIFO

			break;
		case 11: //Buffer Clear
			
			break;
		case 12: //Converter – Lower Case ASCII Enumeration
			
			break;
		case 13:  //Converter – Upper Case ASCII Enumeration
			
			break;
		case 14: //Converter – ASCII Numeral
			
			break;
		case 15: //Converter – TBAS Enumeration
			
			break;
		case 16: //ALU – Add
			
			break;
		case 17: //ALU – Sub
			
			break;
		case 18: //ALU – Mul
			
			break;
		case 19: //ALU – Div
			
			break;
		case 20: //ALU – Bit And
			
			break;
		case 21: //ALU – Bit Or
			
			break;
		case 22: //ALU – Logical Not
			
			break;
		case 23: //ALU – Bit Xor
			
			break;
		case 24: //Meta – Get MPTR
			
			break;
		case 25: //Meta – Get EPTR
			
			break;
		case 26: //Meta – Relative Jump Left
			
			break;
		case 27: //Meta – Relative Jump Right
			
			break;
		}

	}

	private void scRead(int mode) {
		Scanner sc = new Scanner(System.in);

		switch (mode) {
		case 1: // Serial Console - Decimal Read
			tDataTape.write(sc.nextInt());
			break;
		case 3: // Serial Console - ASCII Read
			// you can enter more that on char but all beyond the first one will
			// be ignored
			tDataTape.write(sc.next().charAt(0));
			break;
		}
	}

}
