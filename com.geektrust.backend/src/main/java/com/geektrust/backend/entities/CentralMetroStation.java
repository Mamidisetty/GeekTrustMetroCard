package com.geektrust.backend.entities;

import java.util.HashMap;

public class CentralMetroStation implements BaseMetroStation {
	
	public static CentralMetroStation centralMetroStation;
	
	public int total_collection;
	
	public int total_discount;
	
	public final String name="CENTRAL";
	
	HashMap<String,Integer> passengerCountByMap=new HashMap<String, Integer>();
	
	public CentralMetroStation() {
		
		passengerCountByMap.put("KID", 0);
		
		passengerCountByMap.put("ADULT", 0);
		
		passengerCountByMap.put("SENIOR_CITIZEN", 0);
		
		
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int getTotal_collection() {
		// TODO Auto-generated method stub
		return total_collection;
	}

	public int getTotal_discount() {
		// TODO Auto-generated method stub
		return total_discount;
	}

	public void setTotal_discount(int total_discount) {
		
		this.total_discount=total_discount;
		
	}

	public void setTotal_collection(int total_collection) {
		this.total_collection=total_collection;
		
	}

	public HashMap<String, Integer> getPassengerCountByMap() {
		// TODO Auto-generated method stub
		return passengerCountByMap;
	}

	public void setPassengerCountByMap(HashMap<String, Integer> passengerCountByMap) {
		
		this.passengerCountByMap=passengerCountByMap;
		
	}

	public static CentralMetroStation getCentralMetroStation() {
		
		if(centralMetroStation==null) {
			centralMetroStation=new CentralMetroStation();
		}
		return centralMetroStation;
	}
	
	public static void destroy() {
		centralMetroStation=null;
	}
}
