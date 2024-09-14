package com.geektrust.backend.repositories;

import java.util.HashMap;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.geektrust.backend.entities.MetroCard;

public class MetroCardRepositoryTest {
	
	private ICardRepository iCardRepository;
	
	@BeforeEach
	void setup()
	{
		MetroCard card1=new MetroCard("MC1",1500);
		MetroCard card2=new MetroCard("MC2",678);
		MetroCard card3=new MetroCard("MC3",10000);
		
		HashMap<String, MetroCard>  cardMap=new HashMap<>();
		cardMap.put(card1.getId(),card1);
		cardMap.put(card2.getId(), card2);
		cardMap.put(card3.getId(), card3);
		iCardRepository=new MetroCardRepository(cardMap);
		
	}
	@Test
	@DisplayName("save method should create and return new MetroCard")
	public void testSaveEntity() {
		MetroCard sampleCard=new MetroCard("MC1", 50000);
		MetroCard actualResultCard=iCardRepository.save(sampleCard);
		Assertions.assertEquals(sampleCard,actualResultCard);
		
	}
	@Test
	@DisplayName("Exists /find method should return if card found on repository")
	public void testExistsAndFindById() {
		boolean isFound=iCardRepository.existsById("MC1");
		Optional<MetroCard> actualOptCard=iCardRepository.findById("MC1");
		MetroCard actualCard=actualOptCard.get();
		Assertions.assertEquals("MC1", actualCard.getId());
		Assertions.assertTrue(isFound);	}
}
