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
					tInstructionTape.setInstructionPointer(loopAddress);
				}
				break;

			}

			tInstructionTape.advanceTape();
		} while (tInstruction != 'n');

	}

	private void inPutOutPut() {
		byte mCellVal = tDataTape.readTape();
		
		switch (outPutMode) {
		case 0: //Serial Console - Decimal Write
			System.out.print(mCellVal);
			break;
		case 1: //Serial Console - Decimal Read
			scRead(1);
			break;
		case 2: //Serial Console - ASCII Writ
			System.out.print((char) (int) mCellVal);
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
			tDataBuffer.enqueue(mCellVal);
			break;
		case 9: //Buffer Dequeue – FILO
			tDataBuffer.dequeue(true);
			break;
		case 10: //Buffer Dequeue – FIFO
			tDataBuffer.dequeue(false);
			break;
		case 11: //Buffer Clear
			tDataBuffer.clearBuffer();
			break;
		case 12: //Converter – Lower Case ASCII Enumeration
			if (mCellVal <= 25 && mCellVal >= 0)
			tDataTape.write((byte)LCS_ALPHA[mCellVal]);
			break;
		case 13:  //Converter – Upper Case ASCII Enumeration
			if (mCellVal <= 25 && mCellVal >= 0)
			tDataTape.write((byte)UCS_ALPHA[mCellVal]);
			break;
		case 14: //Converter – ASCII Numeral
			if (mCellVal <= 8 && mCellVal >= 0)
			tDataTape.write((byte)DIGiTS[mCellVal]);
			break;
		case 15: //Converter – TBAS Enumeration
			if (mCellVal <= 6 && mCellVal >= 0)
			tDataTape.write((byte)TBAS_ENUM[mCellVal]);
			break;
		case 16: //ALU – Add
			tDataTape.write((byte)(tDataTape.readTape() + tDataBuffer.dequeue(false)));
			break;
		case 17: //ALU – Sub
			tDataTape.write((byte)(tDataTape.readTape() - tDataBuffer.dequeue(false)));
			break;
		case 18: //ALU – Mul
			tDataTape.write((byte)(tDataTape.readTape() * tDataBuffer.dequeue(false)));
			break;
		case 19: //ALU – Div
			tDataTape.write((byte)(tDataTape.readTape() / tDataBuffer.dequeue(false)));
			break;
		case 20: //ALU – Bit And
			tDataTape.write((byte)(tDataTape.readTape() & tDataBuffer.dequeue(false)));
			break;
		case 21: //ALU – Bit Or
			tDataTape.write((byte)(tDataTape.readTape() | tDataBuffer.dequeue(false)));
			break;
		case 22: //ALU – Logical Not
			tDataTape.write((byte)(tDataTape.readTape() ^ (byte)255));
			break;
		case 23: //ALU – Bit Xor
			tDataTape.write((byte)(tDataTape.readTape() ^ tDataBuffer.dequeue(false)));
			break;
		case 24: //Meta – Get MPTR
			tDataTape.write((byte)tDataTape.getDataPointer());
			break;
		case 25: //Meta – Get EPTR
			tDataTape.write((byte)(tInstructionTape.getInstructionPointer()+1));
			break;
		case 26: //Meta – Relative Jump Left
			int tempLeftJump = tInstructionTape.getInstructionPointer() - tDataTape.readTape();
			if ( tempLeftJump > 0){
				tInstructionTape.setInstructionPointer(tempLeftJump);
			} else {
				tInstructionTape.setInstructionPointer(0);
			}
			break;
		case 27: //Meta – Relative Jump Right
			int tempRightJump = tInstructionTape.getInstructionPointer() + tDataTape.readTape();
			int tInstructionTapeLength = tInstructionTape.getTapeData().length - 1;
			if ( tempRightJump <= tInstructionTapeLength){
				tInstructionTape.setInstructionPointer(tempRightJump);
			} else {
				tInstructionTape.setInstructionPointer(tInstructionTapeLength);
			}
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
