package com.alithya.expedia.exception;

public class InvalidCommandException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8693410637252481173L;

	public InvalidCommandException() {
		super("Game already in progress.");
	}	
}
