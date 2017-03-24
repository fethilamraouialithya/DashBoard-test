package com.alithya.expedia.runner;

import com.alithya.expedia.command.DashBoardCommand;
import com.alithya.expedia.errorstate.ErrorState;
import com.alithya.expedia.factory.CommandFactory;
import com.alithya.expedia.factory.ErrorStateFactory;
import com.alithya.expedia.factory.InputValidatorFactory;
import com.alithya.expedia.model.Game;
import com.alithya.expedia.validator.AbstractValidator;

public class DashBoardInputControl {
	private Game game = null;
		
	public Game getGame() {
		return game;
	}
	
	public void setGame(Game game) {
		this.game = game;
	}
	
	public void performAction(String input) throws Exception {
				
		AbstractValidator validator = InputValidatorFactory.getInputValidator(input);
		DashBoardCommand command = CommandFactory.getCommand(game, validator);
		ErrorState errorState = ErrorStateFactory.getErrorState(game, validator);
		
		if(command != null && errorState == null) {
			this.game = command.execute(input, game);
		} else {
			errorState.throwError();
		}
	}
}
