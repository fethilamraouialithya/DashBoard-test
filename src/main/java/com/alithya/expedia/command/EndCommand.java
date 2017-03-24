package com.alithya.expedia.command;

import com.alithya.expedia.model.Game;

public class EndCommand implements DashBoardCommand {

	@Override
	public Game execute(String input, Game game) {
		/* The end state is an additional feature:
		We can control whether a game could be restarted or not if it is ended. 
		For now we return just null.  
		game.setState(GameState.STATE_END.getStateValue()); return game;*/
		return null;
	}

}
