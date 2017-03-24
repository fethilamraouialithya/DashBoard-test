package com.alithya.expedia.exception;

public class NoSuchTeamException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9106802624497010576L;

	public NoSuchTeamException() {
		super("No such team.");
	}
}
