package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.BaseMetroStation;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.PassengersType;
import com.geektrust.backend.exception.InvalidPassengerTypeException;
import com.geektrust.backend.exception.InvalidStationException;
import com.geektrust.backend.service.IMetroCardService;
import com.geektrust.backend.service.IMetroStationService;
import com.geektrust.backend.service.MetroStationFactory;

public class MetroCheckInCommand implements MetroICommand{
	
	private final IMetroCardService metroCardService;
	
	private final IMetroStationService metroStationService;
	
	
	public MetroCheckInCommand(IMetroCardService metroCardService,IMetroStationService metroStationService) {
		
		this.metroCardService=metroCardService;
		this.metroStationService=metroStationService;
	}

	@Override
	public void excute(List<String> tokens) {
		String cardId= tokens.get(1);
		String passenger=tokens.get(2);
		String stationName=tokens.get(3);
		// input data validation for MetroCard
		MetroCard card=null;
		try {
			card=metroCardService.getCardById(cardId);
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		//input validation for passenger and station
		try {
			if(!(passenger.equals("ADULT")||passenger.equals("KID")||passenger.equals("SENIOR_CITIZEN"))) {
				throw  new InvalidPassengerTypeException(passenger+" is an invalid passenger type");
			}
	        if(!(stationName.equals("AIRPORT")|| stationName.equals("CENTRAL"))) {
	        	throw new InvalidStationException(stationName+" is an invalid station");
	        }
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		PassengersType passengersType=PassengersType.valueOf(passenger);
		BaseMetroStation metroStation=MetroStationFactory.getStationEntity(stationName);
		metroStationService.checkIn(card, passengersType, metroStation);
	}

}
