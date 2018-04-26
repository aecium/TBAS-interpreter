package tbas;

import java.io.Console;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//TBAS Processing Unit (TPU)

public class TPU {
	
	private final char[] UCS_ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final char[] LCS_ALPHA = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private final char[] DIGiTS = "0123456789".toCharArray();
	private final char[] TBAS_ENUM = "+-<>[]=?".toCharArray();
	
	private DataTape tDataTape = new DataTape();
	private InstructionTape tInstructionTape;
	private DataBuffer tDataBuffer = new DataBuffer();
	private Integer loopAddress = null;
	private int outPutMode = 0;

	TPU(char[] instructions) {
		tInstructionTape = new InstructionTape(instructions);
	}

	public void run() {
		char tInstruction = 'n';

		do {
			tInstruction = tInstructionTape.getInstruction();

			switch ((byte)tInstruction) {

			case (byte)'+':
				tDataTape.incrementCellData();
				break;
			case (byte)'-':
				tDataTape.decrementCellData();
				break;
			case (byte)'?':
				inPutOutPut();
				break;
			case (byte)'=':
				outPutMode = tDataTape.readTape();
				break;
			case (byte)'>':
				tDataTape.advanceTape();
				break;
			case (byte)'<':
				tDataTape.retreatTape();
				break;
			case (byte)'[':
				loopAddress = tInstructionTape.getInstructionPointer();
				break;
			case (byte)']':
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
			tDataBuffer.loadBuffer(tInstructionTape.getTapeData());
			break;
		case 7: //Execute Task
			
			break;
		case 8: //Buffer Enqueue
			tDataBuffer.enqueue(tDataTape.readTape().byteValue());
			break;
		case 9: //Buffer Dequeue – FILO
			
			break;
		case 10: //Buffer Dequeue – FIFO

			break;
		case 11: //Buffer Clear
			tDataBuffer.clearBuffer();
			break;
		case 12: //Converter – Lower Case ASCII Enumeration
			tDataTape.write((byte)LCS_ALPHA[tDataTape.readTape()]);
			break;
		case 13:  //Converter – Upper Case ASCII Enumeration
			tDataTape.write((byte)UCS_ALPHA[tDataTape.readTape()]);
			break;
		case 14: //Converter – ASCII Numeral
			tDataTape.write((byte)DIGiTS[tDataTape.readTape()]);
			break;
		case 15: //Converter – TBAS Enumeration
			tDataTape.write((byte)TBAS_ENUM[tDataTape.readTape()]);
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
			tDataTape.write(sc.nextByte());
			break;
		case 3: // Serial Console - ASCII Read
			// you can enter more that on char but all beyond the first one will
			// be ignored
			tDataTape.write((byte)sc.next().charAt(0));
			break;
		}
	}

}
