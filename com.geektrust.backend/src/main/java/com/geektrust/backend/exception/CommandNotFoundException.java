package com.geektrust.backend.exception;

public class CommandNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommandNotFoundException (String message) {
		
		super(message);
	}

}
