package com.geektrust.backend.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.geektrust.backend.service.MetroStationFactory;

@DisplayName("MetroStation test")
public class MetroStationTest {
	
	@Test
	@DisplayName("Test MetroAirport entity")
	public void testMetroAirport() {
		
		BaseMetroStation airport=MetroStationFactory.getStationEntity("AIRPORT");
		Assertions.assertTrue(airport instanceof AirportMetroStation);
		
	}
	
	@Test
	@DisplayName("TestCentralMetroStation entity")
	public void testCentralMetroStation() {
		BaseMetroStation central=MetroStationFactory.getStationEntity("CENTRAL");
		Assertions.assertTrue(central instanceof CentralMetroStation);
	}

}
