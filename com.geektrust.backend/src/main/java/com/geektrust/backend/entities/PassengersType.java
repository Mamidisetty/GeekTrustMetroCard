package com.geektrust.backend.entities;

public enum PassengersType {
	
	ADULT(200),
	
	SENIOR_CITIZEN(100),
	
	KID(50);
	
	private int cost;

	//constructor
	
	PassengersType(int cost) {
		// TODO Auto-generated constructor stub
		this.setCost(cost);
	}

	//getters and setters
	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	

}
