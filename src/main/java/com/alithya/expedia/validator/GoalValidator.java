package com.alithya.expedia.validator;

public class GoalValidator extends AbstractValidator {

	public GoalValidator(String input) {
		super(input);
	}
	
	@Override
	public boolean validate() {
		String[] parts = super.getInput().split("'");
		if(parts.length == 3 && parts[0].trim().length() >= MAX_LENGTH && parts[1].trim().length() > MAX_LENGTH && parts[2].trim().length() > MAX_LENGTH) {
			try {
				// Check the first part is really a number
				Integer.parseInt(parts[0].trim());
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		
		return false;
	}
}
