package com.alithya.expedia.command;

import com.alithya.expedia.model.Game;

public interface DashBoardCommand {
	Game execute(String input, Game game) throws Exception;
}
