package com.geektrust.backend.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.BaseMetroStation;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.PassengersType;
import com.geektrust.backend.repositories.ICardRepository;
import com.geektrust.backend.service.MetroStationFactory;
import com.geektrust.backend.service.MetroStationService;

@DisplayName("MetroStationService Test")
@ExtendWith(MockitoExtension.class)
public class MetroStationServiceTest {
	@Mock
	private ICardRepository iCardRepository;
	
	@InjectMocks
	private MetroStationService stationServic;
	
	private BaseMetroStation airport;
	
	private BaseMetroStation central;
	
	@BeforeEach
	public void setup() {
		
		airport=MetroStationFactory.getStationEntity("AIRORT");
		central=MetroStationFactory.getStationEntity("CENTRAL");
		airport.setTotal_collection(0);
        central.setTotal_collection(0);
        
	}
	@Test
	@DisplayName("Adult first time travelling will be charged 200")
	public void testAdultCheckIn() {
		
		Integer preCheckInBalance=500;
		MetroCard card=new MetroCard("MC1", preCheckInBalance);
		PassengersType passengersType=PassengersType.ADULT;
		BaseMetroStation station=airport;
		
		stationServic.checkIn(card, passengersType, station);
		
		Integer postCheckInBalance= card.getBalance();
		Integer deductedBalance=preCheckInBalance-postCheckInBalance;
		
		Assertions.assertEquals(200, deductedBalance);
		Assertions.assertEquals(200, station.getTotal_collection());
		
	}
	@Test
	@DisplayName("Kid first time travelling will be charged 50")
	public void testKidCheckIn() {
		Integer preCheckInBalance=500;
		MetroCard card=new MetroCard("MC2",preCheckInBalance);
		PassengersType passengersType=PassengersType.SENIOR_CITIZEN;
		BaseMetroStation station=airport;
		
		stationServic.checkIn(card, passengersType, station);
		
		Integer postCheckInBalance=card.getBalance();
		Integer deductedBalance=preCheckInBalance-postCheckInBalance;
		
		Assertions.assertEquals(50,deductedBalance);
		Assertions.assertEquals(50, station.getTotal_collection());
	}
	
	@Test
	@DisplayName("SeniorCitizen first time travelling will be charged 50")
	public void testSeniorCheckIn() {
		
		Integer preCheckInBalance=500;
		MetroCard card=new MetroCard("MC3",preCheckInBalance);
		PassengersType passengersType=PassengersType.SENIOR_CITIZEN;
		BaseMetroStation station=airport;
		
		stationServic.checkIn(card, passengersType, station);
		
		Integer postCheckInBalance=card.getBalance();
		Integer deductedBalance=preCheckInBalance-postCheckInBalance;
		
		Assertions.assertEquals(100, deductedBalance);
		Assertions.assertEquals(100,station.getTotal_collection());
		
		
	}
	@AfterEach
	public void destroyAllStations() {
		MetroStationFactory.destroyAllStation();
		
	}
	

}
