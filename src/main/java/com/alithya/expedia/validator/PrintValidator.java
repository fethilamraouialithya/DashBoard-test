package com.alithya.expedia.validator;

public class PrintValidator extends AbstractValidator {

	public PrintValidator(String input) {
		super(input);
	}
	
	@Override
	public boolean validate() {
		if("Print".equalsIgnoreCase(super.getInput())){
			return true;
		}
		
		return false;
	}

}
