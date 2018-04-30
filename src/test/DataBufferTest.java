package test;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import tbas.DataBuffer;

public class DataBufferTest {

	@Test
	public void testNewDataBuffer(){
		DataBuffer tDataBuffer = new DataBuffer();
		
		assertTrue(tDataBuffer.getBufferData().isEmpty());
		assertThat(tDataBuffer.getBufferPointer(),is(equalTo(0)));
	}
	
	
	
	
}
