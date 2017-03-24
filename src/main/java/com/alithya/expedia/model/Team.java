package com.alithya.expedia.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
	private String name;
	private String country;
	private List<Player> players = new ArrayList<>();
	
	public Team(String country) {
		this(country, null, null);
	}
	
	public Team(String country, String name, List<Player> players) {
		super();
		this.name = name;
		this.country = country;
		this.players = players;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public String resolveName() {
		if(name != null && country != null) {
			return name + " of " + country;
		} else if( name != null) {
			return name;
		} else {
			return country;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
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
		Team other = (Team) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		return true;
	}
}
