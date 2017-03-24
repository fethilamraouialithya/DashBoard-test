package com.alithya.expedia.model;

public class Goal implements Comparable<Goal> {
	private Team team;
	private Player player;
	private int goalTime;

	public Goal(Team team, Player player, int goalTime) {
		super();
		this.team = team;
		this.player = player;
		this.goalTime = goalTime;
	}

	public Team getTeam() {
		return team;
	}

	public Player getPlayer() {
		return player;
	}

	public int getGoalTime() {
		return goalTime;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setGoalTime(int goalTime) {
		this.goalTime = goalTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + goalTime;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
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
		Goal other = (Goal) obj;
		if (goalTime != other.goalTime)
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.player.resolveName() + " " + this.goalTime + "'";
	}

	@Override
	public int compareTo(Goal goal) {
		return (this.goalTime < goal.getGoalTime()) ? -1 : ((this.goalTime == goal.getGoalTime()) ? 0 : 1);
	}
}
