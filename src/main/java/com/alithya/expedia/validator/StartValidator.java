package com.alithya.expedia.validator;

public class StartValidator extends AbstractValidator {

	public StartValidator(String input) {
		super(input);
	}
	
	@Override
	public boolean validate() {
		// The Start command should contain two parts "[0] vs. [1]". Each part should have at least MAX_LENGTH character.
		String[] teams = super.getInput().split(" vs. ");
		if(teams.length == 2 && teams[0].substring(START_COMMAND_BEGINNING.length()).trim().length() > MAX_LENGTH && teams[1].trim().length() > MAX_LENGTH) {
			return true;
		}
		
		return false;
	}
}
