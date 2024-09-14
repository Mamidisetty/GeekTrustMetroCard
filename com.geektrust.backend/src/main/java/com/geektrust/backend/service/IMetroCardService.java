package com.geektrust.backend.service;

import com.geektrust.backend.entities.MetroCard;

public interface IMetroCardService {
	
	public MetroCard createCard(String id,int balance);
	
	public MetroCard getCardById(String id) throws Exception;

}
