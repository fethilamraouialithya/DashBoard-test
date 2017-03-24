package com.alithya.expedia.runner;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.alithya.expedia.enums.GameState;
import com.alithya.expedia.exception.InvalidCommandException;
import com.alithya.expedia.exception.InvalidPrintCommandException;
import com.alithya.expedia.exception.InvalidStartCommandException;
import com.alithya.expedia.exception.NoGameInProgressException;
import com.alithya.expedia.model.Game;
import com.alithya.expedia.model.Team;
import com.alithya.expedia.runner.DashBoardInputControl;

public class DashBoardInputControlTest { 
	private String input;
	private DashBoardInputControl dashBoardInputControl;
	private Game game;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		game = new Game(new Team("England"), new Team("Italy"), null);
		dashBoardInputControl = new DashBoardInputControl();
		dashBoardInputControl.setGame(game);
	}
	
	@Test
	public void testPerformActionStartCommandGameNotStarted() {
		input = "start: England vs. Italy";
		dashBoardInputControl.setGame(null);
		try {
			dashBoardInputControl.performAction(input);
		} catch (Exception e) {
			// Should not hit this catch
			fail("Should not hit this catch");
		}
	}
	
	@Test
	public void testPerformActionOtherCommandGameNotStarted() throws Exception {
		input = "90 'England' Beckham";
		dashBoardInputControl.setGame(null);
		thrown.expect(NoGameInProgressException.class);
		dashBoardInputControl.performAction(input);
	}
	
	@Test
	public void testPerformActionBadCommandGameNotStarted() throws Exception {
		input = "test";
		dashBoardInputControl.setGame(null);
		thrown.expect(InvalidStartCommandException.class);
		dashBoardInputControl.performAction(input);
	}
	
	@Test
	public void testPerformActionStartCommandGameStarted() throws Exception {
		input = "start: England vs. Italy";
		thrown.expect(InvalidCommandException.class);
		dashBoardInputControl.performAction(input);
	}
		
	@Test
	public void testPerformActionBadCommandGameStarted() throws Exception {
		input = "test";
		thrown.expect(InvalidPrintCommandException.class);
		dashBoardInputControl.performAction(input);
	}
	
	@Test
	public void testPerformActionOtherCommandGameStarted() {
		input = "90 'England' Beckham";
		try {
			dashBoardInputControl.performAction(input);
		} catch (Exception e) {
			// Should not hit this catch
			fail("Should not hit this catch");
		}
	}
	
	@Test
	public void testPerformActionStartCommandGameEnded() throws Exception {
		input = "start: England vs. Italy";
		Game gameEnded = dashBoardInputControl.getGame();
		gameEnded.setState(GameState.STATE_END.getStateValue());
		dashBoardInputControl.setGame(gameEnded);
		try {
			dashBoardInputControl.performAction(input);
		} catch (Exception e) {
			// Should not hit this catch
			fail("Should not hit this catch");
		}
	}
	
	@Test
	public void testPerformActionOtherCommandGameEnded() throws Exception {
		input = "90 'England' Beckham";
		Game gameEnded = dashBoardInputControl.getGame();
		gameEnded.setState(GameState.STATE_END.getStateValue());
		dashBoardInputControl.setGame(gameEnded);
		thrown.expect(NoGameInProgressException.class);
		dashBoardInputControl.performAction(input);
	}
	
	@Test
	public void testPerformActionBadCommandGameEnded() throws Exception {
		input = "test";
		Game gameEnded = dashBoardInputControl.getGame();
		gameEnded.setState(GameState.STATE_END.getStateValue());
		dashBoardInputControl.setGame(gameEnded);
		thrown.expect(InvalidStartCommandException.class);
		dashBoardInputControl.performAction(input);
	}
}
