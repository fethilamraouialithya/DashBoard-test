package com.alithya.expedia.factory;

import com.alithya.expedia.enums.InputValidatorEnum;
import com.alithya.expedia.validator.EndValidator;
import com.alithya.expedia.validator.GoalValidator;
import com.alithya.expedia.validator.AbstractValidator;
import com.alithya.expedia.validator.PrintValidator;
import com.alithya.expedia.validator.StartValidator;

public class InputValidatorFactory {

	private InputValidatorFactory() {}
	
	public static AbstractValidator getInputValidator(String input) {		
		if(input.toLowerCase().startsWith(InputValidatorEnum.VALIDATOR_START.getInputValidatorValue())) {
			return new StartValidator(input);
		} else if(input.toLowerCase().startsWith(InputValidatorEnum.VALIDATOR_END.getInputValidatorValue())) {
			return new EndValidator(input);
		} else if(input.toLowerCase().startsWith(InputValidatorEnum.VALIDATOR_PRINT.getInputValidatorValue())){
			return new PrintValidator(input);
		} else {
			return new GoalValidator(input);
		}
	}
}
