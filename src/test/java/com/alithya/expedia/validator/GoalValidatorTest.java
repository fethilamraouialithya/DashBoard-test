package com.alithya.expedia.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GoalValidatorTest {

	private GoalValidator goalValidator;

	@Test
	public void testValidateEmpty() {
		goalValidator = new GoalValidator("");
		assertFalse(goalValidator.validate());
	}
	
	@Test
	public void testValidateBad() {
		goalValidator = new GoalValidator("test");
		assertFalse(goalValidator.validate());
	}

	@Test
	public void testValidateCorrect() {
		goalValidator = new GoalValidator("45 'Team' player");
		assertTrue(goalValidator.validate());
	}

}
