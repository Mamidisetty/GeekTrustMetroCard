package com.geektrust.backend.appConfig;

import com.geektrust.backend.commands.MetroBalanceCommand;
import com.geektrust.backend.commands.MetroCheckInCommand;
import com.geektrust.backend.commands.MetroCommandInvoker;
import com.geektrust.backend.commands.MetroPrintSummary;
import com.geektrust.backend.repositories.ICardRepository;
import com.geektrust.backend.repositories.MetroCardRepository;
import com.geektrust.backend.service.IMetroCardService;
import com.geektrust.backend.service.IMetroStationService;
import com.geektrust.backend.service.MetroCardService;
import com.geektrust.backend.service.MetroStationService;

public class MetroApplicationConfig {
	
	//Initialize repository,service and command layer & inject appropriate dependencies;
	
	private final ICardRepository iCardRepository=new MetroCardRepository();
	
	private final IMetroCardService metroCardService=new MetroCardService(iCardRepository);
	
	private final IMetroStationService metroStationService=new MetroStationService(iCardRepository);
	
	private final MetroBalanceCommand metroBalanceCommand=new MetroBalanceCommand(metroCardService);
	
	private final MetroCheckInCommand metroCheckInCommand=new MetroCheckInCommand(metroCardService, metroStationService);
	
	private final MetroPrintSummary printSummary= new MetroPrintSummary(metroStationService);
	
	private final MetroCommandInvoker commandInvoker=new MetroCommandInvoker();
	
	public MetroCommandInvoker getCommandInvoker() {
		commandInvoker.register("BALANCE", metroBalanceCommand);
		commandInvoker.register("CHECK_IN", metroCheckInCommand);
		commandInvoker.register("PRINT_SUMMARY", printSummary);
		return commandInvoker;
	}
	

}
