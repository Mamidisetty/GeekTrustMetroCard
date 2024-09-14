package com.geektrust.backend.commands;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.service.IMetroCardService;

@DisplayName("MetroBalance Command Test")
@ExtendWith(MockitoExtension.class)
public class MetroBalanceCommandTest {
	@Mock
	private IMetroCardService metroCardService;
	
	@InjectMocks
	private MetroBalanceCommand balanceCommand;

}
