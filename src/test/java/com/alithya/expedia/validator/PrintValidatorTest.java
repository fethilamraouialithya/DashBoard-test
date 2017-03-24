package com.alithya.expedia.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PrintValidatorTest {

	private PrintValidator printValidator;
	
	@Test
	public void testValidateEmpty() {
		printValidator = new PrintValidator("");
		assertFalse(printValidator.validate());
	}
	
	@Test
	public void testValidateBad() {
		printValidator = new PrintValidator("test");
		assertFalse(printValidator.validate());
	}

	@Test
	public void testValidateCorrect() {
		printValidator = new PrintValidator("Print");
		assertTrue(printValidator.validate());
	}

}
