package com.alithya.expedia.factory;

import com.alithya.expedia.enums.GameState;
import com.alithya.expedia.errorstate.ErrorState;
import com.alithya.expedia.errorstate.InputErrorStartErrorState;
import com.alithya.expedia.errorstate.InvalidCommandErrorState;
import com.alithya.expedia.errorstate.InvalidPrintCommandErrorState;
import com.alithya.expedia.errorstate.NoGameInProgressErrorState;
import com.alithya.expedia.model.Game;
import com.alithya.expedia.validator.AbstractValidator;
import com.alithya.expedia.validator.StartValidator;

public class ErrorStateFactory {

	private ErrorStateFactory() {}

	public static ErrorState getErrorState(Game game, AbstractValidator validator) {
		if(game == null) {
			if(!(validator instanceof StartValidator) && validator.validate()) {
				return new NoGameInProgressErrorState();
			} else if(!validator.validate()){
				return new InputErrorStartErrorState();
			}
		}
		if(game != null) {
			if(validator.validate()){
				if(GameState.STATE_START.getStateValue().equals(game.getState()) && validator instanceof StartValidator) {
					return new InvalidCommandErrorState();
				}
				if(!GameState.STATE_START.getStateValue().equals(game.getState()) && !(validator instanceof StartValidator)) {
					return new NoGameInProgressErrorState();
				}
			} else {
				if(GameState.STATE_START.getStateValue().equals(game.getState())){
					return new InvalidPrintCommandErrorState();
				} else {
					return new InputErrorStartErrorState();
				}
			}
			
		}
		
		return null;
	}
}
