package com.geektrust.backend.service;

import com.geektrust.backend.entities.BaseMetroStation;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.PassengersType;

public interface IMetroStationService {
	
	public void checkIn(MetroCard metroCard,PassengersType passengersType,BaseMetroStation baseMetroStation );
	
	public void printSummary(BaseMetroStation baseMetroStation);

}
