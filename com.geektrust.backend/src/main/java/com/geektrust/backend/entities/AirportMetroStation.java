package com.geektrust.backend.entities;

import java.util.HashMap;

public class AirportMetroStation implements BaseMetroStation {

	public static AirportMetroStation airportMetroStation;

	public int total_collection;

	public int total_discount;

	public final String name = "AIRPORT";

	HashMap<String, Integer> passengerCountByMap = new HashMap<String, Integer>();
	
	private AirportMetroStation() {
		
		passengerCountByMap.put("KID", 0);
		
		passengerCountByMap.put("ADULT", 0);
		
		passengerCountByMap.put("SENIOR_CITIZEN", 0);
	}
	

	public String getName() {

		return name;
	}

	public int getTotal_collection() {

		return total_collection;
	}

	public int getTotal_discount() {

		return total_discount;
	}

	public void setTotal_discount(int total_discount) {
		
		this.total_discount=total_discount;

	}

	public void setTotal_collection(int total_collection) {
         this.total_collection=total_collection;
	}

	public HashMap<String, Integer> getPassengerCountByMap() {

		return passengerCountByMap;
	}

	public void setPassengerCountByMap(HashMap<String, Integer> passengerCountByMap) {

		this.passengerCountByMap = passengerCountByMap;

	}
	
	public static AirportMetroStation getAirportMetroStation() {
		if(airportMetroStation==null) {
			airportMetroStation=new AirportMetroStation();
		}
		return airportMetroStation;
	}
   
	
	public static void destroy() {
		
		airportMetroStation=null;
	}
}
