package com.alithya.expedia.exception;

public class InvalidPrintCommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3089283970873727366L;

	public InvalidPrintCommandException() {
		super("Input error - please type 'print' for game details.");
	}
}
