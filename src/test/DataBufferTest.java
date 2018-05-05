package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import tbas.DataBuffer;

public class DataBufferTest {

	@Test
	public void testNewDataBuffer(){
		DataBuffer tDataBuffer = new DataBuffer();
		
		assertTrue(tDataBuffer.getBufferData().isEmpty());
	}
	
	@Test
	public void testLoadClearBuffer(){
		DataBuffer tDataBuffer = new DataBuffer();
		char[] tTestLoad = {'T','e','s','t'};
		ArrayList<Byte> tTestByte = new ArrayList<Byte>();
		
		for (int i =0; i <= tTestLoad.length - 1; i++){
			tTestByte.add((byte)tTestLoad[i]);
		}
		
		tDataBuffer.loadBuffer(tTestLoad);
		
		assertThat(tDataBuffer.getBufferData(),is(equalTo(tTestByte)));
		
		tDataBuffer.clearBuffer();
		
		assertTrue(tDataBuffer.getBufferData().isEmpty());
		
		tTestByte.add((byte)'2');
		
		tDataBuffer.loadBuffer(tTestByte);
		
		assertThat(tDataBuffer.getBufferData(),is(equalTo(tTestByte)));
		
	}
	
	@Test
	public void testEnqueueDequeue(){
		DataBuffer tDataBuffer = new DataBuffer();
		byte tTestByte1 = 11;
		byte tTestByte2 = 22;
		byte tTestByte3 = 33;
		byte tGetTestByte;
		ArrayList<Byte> tTestArray = new ArrayList<Byte>();
		tTestArray.add(tTestByte1);
		tTestArray.add(tTestByte2);
		tTestArray.add(tTestByte3);
		
		tDataBuffer.enqueue(tTestByte1);
		tDataBuffer.enqueue(tTestByte2);
		tDataBuffer.enqueue(tTestByte3);
		assertThat(tDataBuffer.getBufferData(),is(equalTo(tTestArray)));
		tGetTestByte = tDataBuffer.dequeue(true);
		assertThat(tGetTestByte,is(equalTo(tTestByte1)));
		tTestArray.remove(0);
		assertThat(tDataBuffer.getBufferData(),is(equalTo(tTestArray)));
		tGetTestByte = tDataBuffer.dequeue(false);
		assertThat(tGetTestByte,is(equalTo(tTestByte3)));
		tTestArray.remove(1);
		assertThat(tDataBuffer.getBufferData(),is(equalTo(tTestArray)));
	}
	

}
