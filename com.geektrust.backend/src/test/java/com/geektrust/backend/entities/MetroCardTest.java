
package com.geektrust.backend.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("MetroCard Entity Test")
public class MetroCardTest {

	@Test
	@DisplayName("Tests card entity instantion")
	public void testMetroCardEntity() {
		
		MetroCard card= new MetroCard("MC1",100);
		Assertions.assertEquals("MC1",card.getId());
		Assertions.assertEquals(500, card.getBalance());
		card.setBalance(500);
		Assertions.assertEquals(500,card.getBalance());
	}
}
