package com.alithya.expedia.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EndValidatorTest {

	private EndValidator endValidator;
	
	@Test
	public void testValidateEmpty() {
		endValidator = new EndValidator("");
		assertFalse(endValidator.validate());
	}
	
	@Test
	public void testValidateBad() {;
		endValidator = new EndValidator("test");
		assertFalse(endValidator.validate());
	}

	@Test
	public void testValidateCorrect() {
		endValidator = new EndValidator("End");
		assertTrue(endValidator.validate());
	}
}
