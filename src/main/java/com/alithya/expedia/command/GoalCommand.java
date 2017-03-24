package com.alithya.expedia.command;

import com.alithya.expedia.exception.NoSuchTeamException;
import com.alithya.expedia.model.Game;
import com.alithya.expedia.model.Goal;
import com.alithya.expedia.model.Player;
import com.alithya.expedia.model.Team;

public class GoalCommand implements DashBoardCommand {

	@Override
	public Game execute(String input, Game game) throws Exception {
		String[] parts = input.split("'");
		Team team = new Team(parts[1].trim());
		
		if(team.equals(game.getAway()) || team.equals(game.getHome())) {
			int goalTime = Integer.parseInt(parts[0].trim());
			Player player = new Player(parts[2].trim());
			Goal goal = new Goal(team, player, goalTime);
			game.addGoal(team, goal);
			return game;
		} else {
			throw new NoSuchTeamException();
		}
	}

}
