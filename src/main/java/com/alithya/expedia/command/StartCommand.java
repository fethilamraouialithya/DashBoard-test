package com.alithya.expedia.command;

import com.alithya.expedia.model.Game;
import com.alithya.expedia.model.Team;

public class StartCommand implements DashBoardCommand {

	@Override
	public Game execute(String input, Game game) {
		String[] teams = input.split(" vs. ");
		Team home = new Team(teams[0].substring(6).trim());
		Team away = new Team(teams[1].trim());
		return new Game(home, away, null);
	}

}
