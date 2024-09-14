package com.geektrust.backend.commands;

import java.util.List;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.service.IMetroCardService;

public class MetroBalanceCommand implements MetroICommand{
	
	private final IMetroCardService metroCardService;
	
	public MetroBalanceCommand(IMetroCardService metroCardService) {
		
		this.metroCardService=metroCardService;
	}

	@Override
	public void excute(List<String> tokens) {
		String id= tokens.get(1);
		int balance = Integer.parseInt(tokens.get(2));
		MetroCard metroCard=metroCardService.createCard(id, balance);
		
	}

}
