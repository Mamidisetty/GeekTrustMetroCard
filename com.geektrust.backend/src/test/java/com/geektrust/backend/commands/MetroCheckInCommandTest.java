package com.geektrust.backend.commands;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.BaseMetroStation;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.service.IMetroCardService;
import com.geektrust.backend.service.IMetroStationService;
import static org.mockito.ArgumentMatchers.any;
@DisplayName("Check-In Command test")
@ExtendWith(MockitoExtension.class)
public class MetroCheckInCommandTest {
	
	@Mock
	private IMetroCardService metroCardService;
	
	@Mock
	private IMetroStationService metroStationService;
	
	@InjectMocks
	private MetroCheckInCommand checkInCommand;
	
	@BeforeEach
	public void setUp() {
		
	}
	
	@Test
	@DisplayName("Test Excute Method for check-in Command")
	public void testCheckInCommand() throws Exception{
		
		MetroCard card=new MetroCard("MC1", 5000);
		Mockito.when(metroCardService.getCardById("MC1")).thenReturn(card);
		List<String> inputCommand=new ArrayList<>();
		inputCommand.add("CHECK-IN");
		inputCommand.add("MC1");
		inputCommand.add("ADULT");
		inputCommand.add("AIRPORT");
		checkInCommand.excute(inputCommand);
		Mockito.verify(metroStationService,times(1)).checkIn(any(MetroCard.class), any(),any(BaseMetroStation.class));
		
		
		
	}

}
