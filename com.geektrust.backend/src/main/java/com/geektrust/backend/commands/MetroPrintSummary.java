package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.BaseMetroStation;
import com.geektrust.backend.service.IMetroStationService;
import com.geektrust.backend.service.MetroStationFactory;



public class MetroPrintSummary implements MetroICommand {
	
	private final IMetroStationService metroStationService;
	
	public MetroPrintSummary(IMetroStationService metroStationService) {
		this.metroStationService=metroStationService;
	}

	@Override
	public void excute(List<String> tokens) {
	 BaseMetroStation central= MetroStationFactory.getStationEntity("CENTRAL");
	 BaseMetroStation airport=MetroStationFactory.getStationEntity("AIRPORT");
	 metroStationService.printSummary(central);
	 metroStationService.printSummary(airport);
		
	}

}
