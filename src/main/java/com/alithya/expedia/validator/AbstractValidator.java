package com.alithya.expedia.validator;

public abstract class AbstractValidator {
	public static final int MAX_LENGTH = 1;
	public static final String START_COMMAND_BEGINNING = "start:";
	
	private String input;
	
	public AbstractValidator(String input) {
		super();
		this.input = input;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public abstract boolean validate();
}
