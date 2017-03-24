package com.alithya.expedia.enums;

public enum InputValidatorEnum {
	VALIDATOR_START("start"),
	VALIDATOR_END("end"),
	VALIDATOR_PRINT("print"),
	VALIDATOR_GOAL("goal");

	private String inputValidator;

	public String getInputValidatorValue() {
		return inputValidator;
	}

	private InputValidatorEnum(String inputValidator) {
		this.inputValidator = inputValidator;
	}
}
