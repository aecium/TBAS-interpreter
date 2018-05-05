package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import tbas.InstructionTape;;

public class InstructionTapeTest {
	char[] INSTRUCTIONS = { '+', '+', '=', '+', '?', '+', '?' };

	@Test
	public void testInstructionTape() {
		InstructionTape tInstructionTape = new InstructionTape(INSTRUCTIONS);

		assertTrue(tInstructionTape.getTapeData().equals(INSTRUCTIONS));
		assertTrue(tInstructionTape.getInstructionPointer() == 0);
	}

	@Test
	public void testSetGetAdvanceretRetreatTape() {
		InstructionTape tInstructionTape = new InstructionTape(INSTRUCTIONS);

		tInstructionTape.setInstructionPointer(3);
		assertTrue(tInstructionTape.getInstructionPointer() == 3);
		tInstructionTape.advanceTape();
		assertTrue(tInstructionTape.getInstructionPointer() == 4);
		tInstructionTape.retreatTape();
		tInstructionTape.retreatTape();
		assertTrue(tInstructionTape.getInstructionPointer() == 2);
	}
	
	@Test
	public void testClear(){
		InstructionTape tInstructionTape = new InstructionTape(INSTRUCTIONS);

		tInstructionTape.clearTape();
		assertNull(tInstructionTape.getTapeData());
	}

	@Test
	public void testGetInstruction(){
		InstructionTape tInstructionTape = new InstructionTape(INSTRUCTIONS);
		
		tInstructionTape.setInstructionPointer(2);
		
		assertTrue(tInstructionTape.getInstruction()=='=');
		
		tInstructionTape.setInstructionPointer(10);
		
		assertTrue(tInstructionTape.getInstruction()=='n');
		
		tInstructionTape.setInstructionPointer(-1);
		
		assertTrue(tInstructionTape.getInstruction()=='n');
		
		
		
		
	}
}
