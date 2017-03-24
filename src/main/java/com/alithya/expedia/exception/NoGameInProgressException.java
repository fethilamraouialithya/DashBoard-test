package com.alithya.expedia.exception;

public class NoGameInProgressException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6710218850627846057L;

	public NoGameInProgressException() {
		super("No game currently in progress.");
	}
}
