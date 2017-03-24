package com.alithya.expedia.command;

import java.util.List;
import java.util.stream.Collectors;

import com.alithya.expedia.model.Game;
import com.alithya.expedia.model.Goal;

public class PrintCommand implements DashBoardCommand {

	@Override
	public Game execute(String input, Game game) {
		StringBuilder builder = new StringBuilder();
		List<Goal> homeGoals = game.getHomeGoals();
		List<Goal> awayGoals = game.getAwayGoals();
		builder.append(game.getHome().resolveName()).append(" ").append(getGoalsNumber(homeGoals)).append(getScorers(homeGoals))
				.append(" vs. ").append(game.getAway().resolveName()).append(" ").append(getGoalsNumber(awayGoals))
				.append(getScorers(awayGoals));
		
		System.out.println(builder.toString());		
		return game;
	}

	private int getGoalsNumber(List<Goal> goals) {
		return goals.isEmpty() ? 0 : goals.size();
	}
	
	private String getScorers(List<Goal> goals) {
		
		String scorrer = "";
		
		if(!goals.isEmpty()) {
			scorrer = goals.stream().sorted().map(Goal::toString).collect(Collectors.joining(" ", " (", ")"));
		}
		
		return scorrer; 
	}
}
