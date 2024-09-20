package com.geektrust.backend.commands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.service.IMetroCardService;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

@DisplayName("MetroBalance Command Test")
@ExtendWith(MockitoExtension.class)
public class MetroBalanceCommandTest {
	@Mock
	private IMetroCardService metroCardService;
	
	@InjectMocks
	private MetroBalanceCommand balanceCommand;

	@Test
	@DisplayName("Balance Command should create and return a metro card with given balance")
	public void testMetroBalanceCommand() {
		
		MetroCard card=new MetroCard("MC1", 5000);
		Mockito.when(metroCardService.createCard(anyString(),anyInt())).thenReturn(card);
		
		List<String> balanceCommandInput = new ArrayList<>();
		balanceCommandInput.add("BALANCE");
		balanceCommandInput.add("MC1");
		balanceCommandInput.add("500");
		balanceCommand.excute(balanceCommandInput);
		Mockito.verify(metroCardService,times(1)).createCard(anyString(), anyInt());
		
	}
}
