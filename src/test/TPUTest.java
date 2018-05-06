package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import tbas.*;

public class TPUTest {

	TPU testTPU;
	DataTape mockDataTape = mock(DataTape.class);
	InstructionTape mockInstructionTape = mock(InstructionTape.class);
	DataBuffer mockDataBuffer = mock(DataBuffer.class);

	@Test
	public void testInstruction0() {

		when(mockInstructionTape.getInstruction()).thenReturn('+').thenReturn('n');

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockDataTape, times(1)).incrementCellData();

	}

	@Test
	public void testInstruction1() {

		when(mockInstructionTape.getInstruction()).thenReturn('-').thenReturn('n');

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockDataTape, times(1)).decrementCellData();

	}

	@Test
	public void testInstruction2() {

		when(mockInstructionTape.getInstruction()).thenReturn('?').thenReturn('n');
		when(mockDataTape.readTape()).thenReturn((byte) 66);

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		String tResult = testTPU.run();
		
		assertThat(tResult,is(equalTo("66")));

	}

	@Test
	public void testInstruction3() {

		when(mockInstructionTape.getInstruction()).thenReturn('=').thenReturn('n');

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockDataTape, times(1)).readTape();

	}

	@Test
	public void testInstruction4() {

		when(mockInstructionTape.getInstruction()).thenReturn('>').thenReturn('n');

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockDataTape, times(1)).advanceTape();

	}

	@Test
	public void testInstruction5() {

		when(mockInstructionTape.getInstruction()).thenReturn('<').thenReturn('n');

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockDataTape, times(1)).retreatTape();

	}

	@Test
	public void testInstruction6() {

		when(mockInstructionTape.getInstruction()).thenReturn('[').thenReturn('n');

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockInstructionTape, times(1)).getInstructionPointer();

	}

	@Test
	public void testInstruction7() {

		when(mockInstructionTape.getInstruction()).thenReturn('[').thenReturn(']').thenReturn('n');
		when(mockInstructionTape.getInstructionPointer()).thenReturn(66);
		when(mockDataTape.readTape()).thenReturn((byte)66);
		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockInstructionTape, times(1)).setInstructionPointer(anyInt());

	}
	
	@Test
	public void testInstruction7NullLoopAddress() {

		when(mockInstructionTape.getInstruction()).thenReturn(']').thenReturn('n');
		when(mockDataTape.readTape()).thenReturn((byte)66);
		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockInstructionTape, times(0)).setInstructionPointer(anyInt());

	}
	
	@Test
	public void testInstruction7NullReadData() {

		when(mockInstructionTape.getInstruction()).thenReturn('[').thenReturn(']').thenReturn('n');
		when(mockInstructionTape.getInstructionPointer()).thenReturn(66);

		testTPU = new TPU(mockInstructionTape, mockDataTape, mockDataBuffer);

		testTPU.run();

		verify(mockInstructionTape, times(0)).setInstructionPointer(anyInt());

	}

}
