package com.alithya.expedia.enums;

public enum GameState {
	STATE_START("start"),
	STATE_END("end");

	private String state;

	public String getStateValue() {
		return state;
	}

	private GameState(String state) {
		this.state = state;
	}
}
