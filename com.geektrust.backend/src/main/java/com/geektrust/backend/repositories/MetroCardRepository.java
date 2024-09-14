package com.geektrust.backend.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.geektrust.backend.entities.MetroCard;

public class MetroCardRepository implements ICardRepository  {
	
	private final Map<String,MetroCard> cardMap;
	
	public MetroCardRepository()
	{
		this.cardMap = new HashMap<String, MetroCard>();
		
	}
	
	public MetroCardRepository(HashMap<String, MetroCard> cardMap) {
	
		this.cardMap = cardMap;
	}

	public MetroCard save(MetroCard entity) {
		cardMap.put(entity.getId(), entity);
		return entity;
	}

	public List<MetroCard> findAll() {
		List<MetroCard> cards=new ArrayList<MetroCard>();
		for(String key:cardMap.keySet()) {
		cards.add(cardMap.get(key));
		}
		return cards;
	}

	public Optional<MetroCard> findById(String id) {
		
		return Optional.ofNullable(cardMap.get(id));
	}

	public void delete(MetroCard entity) {
   //		cardMap.remove(entity);
		
	}

	public void deleteById(String id) {
		 cardMap.remove(id);
		
	}

	public long count() {
		
		return cardMap.size();
	}

	public boolean existsById(String id) {
		
		boolean isExists=false;
		if(cardMap.containsKey(id)) {
			
			isExists=true;
			
		}
		
		return isExists;
	}

	
}
