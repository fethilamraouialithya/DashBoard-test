package com.alithya.expedia.factory;

import com.alithya.expedia.command.DashBoardCommand;
import com.alithya.expedia.command.EndCommand;
import com.alithya.expedia.command.GoalCommand;
import com.alithya.expedia.command.PrintCommand;
import com.alithya.expedia.command.StartCommand;
import com.alithya.expedia.enums.GameState;
import com.alithya.expedia.model.Game;
import com.alithya.expedia.validator.AbstractValidator;
import com.alithya.expedia.validator.EndValidator;
import com.alithya.expedia.validator.GoalValidator;
import com.alithya.expedia.validator.PrintValidator;
import com.alithya.expedia.validator.StartValidator;

public class CommandFactory {

	private CommandFactory() {
	}

	public static DashBoardCommand getCommand(Game game, AbstractValidator validator) {
		if(validator.validate()) {
			if((game == null || (game != null && !GameState.STATE_START.getStateValue().equals(game.getState()))) && validator instanceof StartValidator) {
				return new StartCommand();
			}
			if(game != null && GameState.STATE_START.getStateValue().equals(game.getState())) {
				if(validator instanceof EndValidator) {
					return new EndCommand();
				}
				if(validator instanceof PrintValidator) {
					return new PrintCommand();
				}
				if(validator instanceof GoalValidator) {
					return new GoalCommand();
				}
			}
		}
		
		return null;
	}
}
