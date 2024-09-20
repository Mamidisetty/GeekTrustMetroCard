package com.geektrust.backend.commands;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;

import com.geektrust.backend.service.IMetroStationService;


@DisplayName("PrintSummary Command test")
@ExtendWith(MockitoExtension.class)
public class MetroPrintSummaryTest {

	@Mock
	private IMetroStationService stationService;
	
	@InjectMocks
	private MetroPrintSummary printSummary;
	
	@Test
	@DisplayName("print summary should invoke printsummary method")
	public void testPrintSummaryMethod() {
		List<String> inputCommand=new ArrayList<String>();
		inputCommand.add("PRINT_SUMMARY");
		printSummary.excute(inputCommand);
		Mockito.verify(stationService,times(2)).printSummary(any());
		
	}
	
}
