package com.geektrust.backend.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.geektrust.backend.entities.BaseMetroStation;
import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.entities.PassengersType;
import com.geektrust.backend.repositories.ICardRepository;

public class MetroStationService implements IMetroStationService {

	private final ICardRepository iCardRepository;

	public MetroStationService(ICardRepository iCardRepository) {
		this.iCardRepository = iCardRepository;
	}

	@Override
	public void checkIn(MetroCard metroCard, PassengersType passengersType, BaseMetroStation baseMetroStation) {

		int cost = passengersType.getCost();

		int discount = 0;

		if (metroCard.isReturnJourney()) {
			discount = cost / 2;
			cost = cost - discount;
			metroCard.setReturnJourney(false);

		} else {
			metroCard.setReturnJourney(true);
		}
		int card_balance = metroCard.getBalance();

		if (card_balance >= cost) {

			card_balance = card_balance - cost;

		} else {

			int due = cost - card_balance;

			int service_charge = (int) ((0.02) * due);

			cost = cost + service_charge;

			card_balance = 0;
		}

		metroCard.setBalance(card_balance);
		iCardRepository.save(metroCard);

		baseMetroStation.setTotal_collection(baseMetroStation.getTotal_collection() + cost);
		baseMetroStation.setTotal_discount(baseMetroStation.getTotal_discount() + discount);

		// populate passenger counts by passenger types

		populatePassengerCountForTheStation(baseMetroStation, passengersType);

	}

	private void populatePassengerCountForTheStation(BaseMetroStation baseMetroStation, PassengersType passengersType) {

		HashMap<String, Integer> passengerCountByTypeMap = baseMetroStation.getPassengerCountByMap();

		String passengerKey = "";

		if (passengersType.ADULT == passengersType) {

			passengerKey = "ADULT";
		} else if (passengersType.KID == passengersType) {

			passengerKey = "KID";
		} else if (passengersType.SENIOR_CITIZEN == passengersType) {

			passengerKey = "SENIOR_CITIZEN";
		}

		// update map

		int count = passengerCountByTypeMap.get(passengerKey);
		count++;
		passengerCountByTypeMap.put(passengerKey, count);
		baseMetroStation.setPassengerCountByMap(passengerCountByTypeMap);

	}

	public int computeCostOfJourney() {
		return 0;

	}
	// Sort a hashmap by its value , if vlaue is equal for any entries sort their
	// keys alphabetically

	public HashMap<String, Integer> sortHashMap(HashMap<String, Integer> map) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (o1.getValue() < o2.getValue()) {

					return 1;
				} else if (o1.getValue() > o2.getValue()) {

					return -1;
				} else {
					if (o1.getKey().charAt(0) > o2.getKey().charAt(0)) {

						return 1;
					} else {
						return -1;
					}
				}
			}
		});
		HashMap<String, Integer> temp = new LinkedHashMap<>();
		for (Map.Entry<String, Integer> al : list) {
			temp.put(al.getKey(), al.getValue());
		}
		return temp;

	}

	 //Prints summary (Total collection , discount and passenger count)
	@Override
	public void printSummary(BaseMetroStation baseMetroStation) {
		HashMap<String, Integer> sortPassengerCountByType = sortHashMap(baseMetroStation.getPassengerCountByMap());
		String name = baseMetroStation.getName();
		int travel_charges = baseMetroStation.getTotal_collection();

		int discount = baseMetroStation.getTotal_discount();
		
		 System.out.println("TOTAL COLLECTION  "+name+" "+travel_charges+" "+discount);
	        System.out.println("PASSENGER_TYPE_SUMMARY");
	        
	        for(Map.Entry<String,Integer> en:sortPassengerCountByType.entrySet()) {
	        	
	        	if(en.getValue()>0) {
	        		System.out.println(en.getKey()+" "+en.getValue());
	        	}
	        }

	}

}
