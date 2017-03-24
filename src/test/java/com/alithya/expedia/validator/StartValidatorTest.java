package com.alithya.expedia.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StartValidatorTest {

	private StartValidator startValidator;
	
	@Test
	public void testValidateEmpty() {
		startValidator = new StartValidator("");
		assertFalse(startValidator.validate());
	}
	
	@Test
	public void testValidateBad() {
		startValidator = new StartValidator("test");
		assertFalse(startValidator.validate());
	}

	@Test
	public void testValidateCorrect() {
		startValidator = new StartValidator("start home vs. away");
		assertTrue(startValidator.validate());
	}

}
