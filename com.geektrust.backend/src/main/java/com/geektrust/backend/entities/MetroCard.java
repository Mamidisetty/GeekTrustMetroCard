package com.geektrust.backend.entities;

public class MetroCard {
	
	private String id;
	
	private int balance;
	
	private boolean isReturnJourney=false;

	public boolean isReturnJourney() {
		return isReturnJourney;
	}

	public void setReturnJourney(boolean isReturnJourney) {
		this.isReturnJourney = isReturnJourney;
	}

	public MetroCard(String id, int balance) {
		
		this.id = id;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	
	
	
	
	
	
	
	

}
