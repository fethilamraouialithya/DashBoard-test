package com.alithya.expedia.command;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.alithya.expedia.command.DashBoardCommand;
import com.alithya.expedia.command.EndCommand;
import com.alithya.expedia.command.GoalCommand;
import com.alithya.expedia.enums.GameState;
import com.alithya.expedia.exception.NoSuchTeamException;
import com.alithya.expedia.model.Game;
import com.alithya.expedia.model.Goal;
import com.alithya.expedia.model.Player;
import com.alithya.expedia.model.Team;

public class DashBoardCommandTest {
	private DashBoardCommand dashBoardCommand; 
	private String input;
	private Player player;
	private int goalTime;
	private Game game;
	private Team home;
	private Team away;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		goalTime = 98;
		player = new Player("Beckham");
		home = new Team("England");
		away = new Team("Italy");
		game = new Game(home, away, null);
	}
	
	@Test
	public void testEndCommandExecute() {
		dashBoardCommand = new EndCommand();
		try {
			assertNull(dashBoardCommand.execute(null, null));
		} catch (Exception e) {
			//Should not hit and not throw an exception
			fail("Sould not throw an exception");
		}
	}

	@Test
	public void testGoalCommandExecuteSuccess() {
		dashBoardCommand = new GoalCommand();
		input = goalTime + " '" + home.resolveName() + "' " + player.getFirstname();
		Game gameWithGoal = game;
		gameWithGoal.addGoal(home, new Goal(home, player, goalTime));
		try {
			assertThat(dashBoardCommand.execute(input, game), equalTo(gameWithGoal));
		} catch (Exception e) {
			//Should not hit and not throw an exception
			fail("Should not throw an exception");
		}
	}
	
	@Test
	public void testGoalCommandExecuteFailure() throws Exception {
		dashBoardCommand = new GoalCommand();
		input = goalTime + " 'Englland' " + player.getFirstname();
		Game gameWithGoal = game;
		gameWithGoal.addGoal(home, new Goal(home, player, goalTime));
		thrown.expect(NoSuchTeamException.class);
		assertThat(dashBoardCommand.execute(input, game), equalTo(gameWithGoal));
	}
		
	@Test
	public void testStartCommandExecute() {
		assertThat(game.getState(), equalTo(GameState.STATE_START.getStateValue()));
	}
}
