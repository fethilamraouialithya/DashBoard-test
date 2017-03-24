package com.alithya.expedia.exception;

public class InvalidStartCommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3777940873240806219L;

	public InvalidStartCommandException() {
		super("Input error - please start a game through typing 'Start: '<Name of Home Team>' vs. '<Name of Away Team>''");
	}
}
