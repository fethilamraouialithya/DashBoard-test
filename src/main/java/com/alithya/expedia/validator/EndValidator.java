package com.alithya.expedia.validator;

public class EndValidator extends AbstractValidator {

	public EndValidator(String input) {
		super(input);
	}
	
	@Override
	public boolean validate() {
		if("End".equalsIgnoreCase(super.getInput())){
			return true;
		}
		
		return false;
	}

}
