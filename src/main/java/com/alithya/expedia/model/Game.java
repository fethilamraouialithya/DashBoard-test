package com.alithya.expedia.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alithya.expedia.enums.GameState;

public class Game {
	private Team home;
	private Team away;
	private Map<Team, List<Goal>> goals = new HashMap<>();
	private Competition competition;
	private String state;

	public Game(Team home, Team away, Competition competition) {
		super();
		this.home = home;
		this.away = away;
		this.goals.put(home, new ArrayList<>());
		this.goals.put(away, new ArrayList<>());
		this.competition = competition;
		this.state = GameState.STATE_START.getStateValue();
	}

	public Team getHome() {
		return home;
	}

	public Team getAway() {
		return away;
	}

	public Map<Team, List<Goal>> getGoals() {
		return goals;
	}

	public Competition getCompetition() {
		return competition;
	}

	public String getState() {
		return state;
	}

	public void setHome(Team home) {
		this.home = home;
	}

	public void setAway(Team away) {
		this.away = away;
	}

	public void setGoals(Map<Team, List<Goal>> goals) {
		this.goals = goals;
	}

	public void setCompetition(Competition competition) {
		this.competition = competition;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void addGoal(Team team, Goal goal) {
		this.goals.get(team).add(goal);
	}

	public List<Goal> getHomeGoals() {
		return this.goals.get(home);
	}

	public List<Goal> getAwayGoals() {
		return this.goals.get(away);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((away == null) ? 0 : away.hashCode());
		result = prime * result + ((competition == null) ? 0 : competition.hashCode());
		result = prime * result + ((goals == null) ? 0 : goals.hashCode());
		result = prime * result + ((home == null) ? 0 : home.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		if (away == null) {
			if (other.away != null)
				return false;
		} else if (!away.equals(other.away))
			return false;
		if (competition == null) {
			if (other.competition != null)
				return false;
		} else if (!competition.equals(other.competition))
			return false;
		if (goals == null) {
			if (other.goals != null)
				return false;
		} else if (!goals.equals(other.goals))
			return false;
		if (home == null) {
			if (other.home != null)
				return false;
		} else if (!home.equals(other.home))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
	
}
