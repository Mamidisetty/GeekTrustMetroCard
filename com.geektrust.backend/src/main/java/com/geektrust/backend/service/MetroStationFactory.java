package com.geektrust.backend.service;

import com.geektrust.backend.entities.AirportMetroStation;
import com.geektrust.backend.entities.BaseMetroStation;
import com.geektrust.backend.entities.CentralMetroStation;

public class MetroStationFactory {
	
	public static BaseMetroStation getStationEntity(String stationName) {
		
		if(stationName.equalsIgnoreCase("AIRPORT")) {
			return AirportMetroStation.getAirportMetroStation();
		}
		else {
			return CentralMetroStation.getCentralMetroStation();
		}
	}
	public static void destroyAllStation() {
		AirportMetroStation.destroy();
		CentralMetroStation.destroy();
	}

}
