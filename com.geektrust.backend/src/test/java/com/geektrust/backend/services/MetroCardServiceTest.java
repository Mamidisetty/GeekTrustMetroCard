package com.geektrust.backend.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.junit.jupiter.MockitoExtension;

import com.geektrust.backend.entities.MetroCard;
import com.geektrust.backend.repositories.ICardRepository;
import com.geektrust.backend.service.MetroCardService;

@DisplayName("MetroCardService Test")
@ExtendWith(MockitoExtension.class)
public class MetroCardServiceTest {
	 @Mock
	private ICardRepository iCardRepository;
	 
	 @InjectMocks
	 private MetroCardService cardService;
	 
	 @Test
	 @DisplayName("Create a new card with given Id and balance")
	 public void testCardCreateService() {
		 
		 MetroCard expectedCard = new MetroCard("MC100", 5000);
		 Mockito.when(iCardRepository.save(any())).thenReturn(expectedCard);
		 MetroCard actualCard=cardService.createCard("MC100", 5000);
		 Assertions.assertEquals(expectedCard.getId(), actualCard.getId());
	 }

	

}
