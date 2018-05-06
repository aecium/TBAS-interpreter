package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import tbas.Tbas;

public class TbasTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private Tbas tTbas = new Tbas();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void restoreStreams() {
	    System.setOut(System.out);
	    System.setErr(System.err);
	}

	@Test
	public void testMain(){
		
		Tbas.main(new String[]{});
		assertEquals("321", outContent.toString());
		outContent.reset();
		Tbas.main(new String[]{"++=++++++[->++++++++<]>+?+?+?"});
		assertEquals("ABC",outContent.toString());
		
	}
	
	
}
