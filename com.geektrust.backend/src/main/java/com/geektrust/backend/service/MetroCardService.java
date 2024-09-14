package com.geektrust.backend.service;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.exception.MetroCardNotFoundException;
import com.geektrust.backend.repositories.ICardRepository;

public class MetroCardService implements IMetroCardService {
	
	private final ICardRepository cardRepository;
	


	public MetroCardService(ICardRepository cardRepository) {
		this.cardRepository = cardRepository;
	}

	public MetroCard createCard(String id, int balance) {
		MetroCard card=new MetroCard(id, balance);
		cardRepository.save(card);
		return card;
	}

	public MetroCard getCardById(String id) throws MetroCardNotFoundException {
		final MetroCard card=cardRepository.findById(id).orElseThrow(()-> new MetroCardNotFoundException(id+"does not exists in Metro Card Repository"));
		return card;
	}

}
