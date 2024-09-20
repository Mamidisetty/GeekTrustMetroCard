package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("App Test")
public class AppTest {
	
	private final PrintStream standardOut=System.out;
	private final ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
	
	@BeforeEach
	public void setUp() {
		
		System.setOut(new PrintStream(outputStream));
	}
	  /* This test comprehensively covers example-1 give on the question */
	@Test
	@DisplayName("Integration Test Case-1")
	public void integrationTest_Example() throws Exception {
		
		List<String> inputCommands=new ArrayList<String>();
	    String c1 = "BALANCE MC1 600";
        String c2 = "BALANCE MC2 500";
        String c3 = "BALANCE MC3 50" ;
        String c4 = "BALANCE MC4 50" ;
        String c5 = "BALANCE MC5 200" ;
        String c6 = "CHECK_IN MC1 ADULT CENTRAL";
        String c7 = "CHECK_IN MC2 SENIOR_CITIZEN CENTRAL" ;
        String c8 = "CHECK_IN MC1 ADULT AIRPORT" ;
        String c9 = "CHECK_IN MC3 KID AIRPORT" ;
        String c10 = "CHECK_IN MC4 ADULT AIRPORT";
        String c11 = "CHECK_IN MC5 KID AIRPORT" ;
        String c12 = "PRINT_SUMMARY";
		inputCommands.add(c1);
		inputCommands.add(c2);
		inputCommands.add(c3);
		inputCommands.add(c4);
		inputCommands.add(c5);
		inputCommands.add(c6);
		inputCommands.add(c7);
		inputCommands.add(c8);
		inputCommands.add(c9);
		inputCommands.add(c10);
		inputCommands.add(c11);
		inputCommands.add(c12);
		
		
		
		String expectedOutput = "TOTAL COLLECTION  CENTRAL 300 0\n"+
			       "PASSENGER_TYPE_SUMMARY\n"+
			       "ADULT 1\n"+
			       "SENIOR_CITIZEN 1\n"+
			       "TOTAL COLLECTION  AIRPORT 403 100\n"+
			       "PASSENGER_TYPE_SUMMARY\n"+
			       "ADULT 2\n"+
			       "KID 2";

			        // Act   
			        App.run(inputCommands);
			        
			        // Assert
			        //System.out.println(outputStreamCaptor.toString().trim());
			        Assertions.assertEquals(expectedOutput,outputStream.toString().trim());
		
	}

	@AfterEach
	public void tearDown() {
		System.setOut(standardOut);
	}
}

