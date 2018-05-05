package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import tbas.DataTape;

public class DataTapeTest {

	@Test
	public void testDataTape() {
		DataTape tDataTape = new DataTape();

		assertTrue(tDataTape.getDataPointer() == 0);
		assertTrue(tDataTape.readTape() == 0);

	}


	@Test
	public void testIncrementDecrementCellData() {
		DataTape tDataTape = new DataTape();

		tDataTape.incrementCellData();
		assertTrue(tDataTape.readTape() == 1);
		tDataTape.decrementCellData();
		assertTrue(tDataTape.readTape() == 0);
		tDataTape.decrementCellData();
		assertTrue(tDataTape.readTape() == 0);

	}
	
	@Test
	public void testWriteAdvanceRetreateTape() {
		DataTape tDataTape = new DataTape();
			
		tDataTape.write((byte)23);
		assertTrue(tDataTape.readTape() == 23);
		
		tDataTape.advanceTape();
		assertTrue(tDataTape.readTape() == 0);
		
		tDataTape.retreatTape();
		assertTrue(tDataTape.readTape() == 23);		
		
		tDataTape.advanceTape();
		assertTrue(tDataTape.readTape() == 0);
		
		
	}
	
}
