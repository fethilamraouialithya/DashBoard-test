Overall solution description:
-----------------------------

The user is invited to add a command that will be performed by the dashBoardInputControl, we are using a factories (validator, command, error state) to select the right input validator, command executer and the error state.

validators: We added four input validators in this scope, each validator has its one validate method that returns a boolean.
command: using command pattern, we added four commands (end, start, goal, print) that running its own logic when calling execute method.
error state: in this scope, the error state throw just the exceptions.

We added in addition of the cited scenarios, 'game is already started' case.

Since there is no control on how a user can enter a goal time by goal command, we add a sort on goal time, so the print command will print sorted goals.

To quit the dashBoard a user can type 'exit' command at any time.


Design patterns used
--------------------

1- Command Pattern

2- State pattern

3- FactoryPattern


Current design benifits:
------------------------

Since we can have future changes, the implementation provided is designed to manage and handle changes and improvements, we can mention some of them: 

- Like having multiple competitions (World cup, champions league, local teams game ...).

- Since we have states, game statistics can be saved at the end state or having chrono at the start state.

- Having control to restart a game or not after it is finished (ex: A game could not be able to start if it is finished).

- A team can have a list of players (playing the game or substitutes, so a scorer can be just one of the players who they are playing the game).


Known issues and areas of enhancments
-------------------------------------

- The same team can play against it self (In this scope we can have England vs. England game, like in video games).

- Just one game is handled

- Scorers name and team. There is no validation for the scorers name or team.

- Goal time. There is no validation on goal time (can be any number ex; 5465465463).


Assumptions:
------------

- When game started:
  - If the user enter a bad command, "input error - please type 'print' for game details" will be displayed.
  - If the user enter start command, "Game already started" will be displayed.
  - If the user enter correct command (print or goal command or end), the command will be executed.
- When game is not started:
  - If the user enter a bad command, "input error - please start a game through typing 'Start: '<Name of Home Team>' vs. '<Name of Away Team>''" will be displayed.
  - If the user enter a correct command, "No game currently in progress" will be displayed.
- Exit case: command format is 'exit'.


Program:
-------------------

It's a spring boot app that receives commandline. user will repeatedly enter command lines until entering exit command.


Scenarios covered by unit tests:
--------------------------------

We added unit tests for the following parts:  

1- dashBoardCommand
 
   Test the behavior of each command (exception throw or success without exception).

2- User input and action to perform
 
   Test the behavior of our perform action depending on the user input.

3- Validators

   Test the validation of each validator with both correct and incorrect command format.


How to generate the jar file:
-----------------------------

- Since we use some Java 8 functionnalities, a java 1.8 version is required.
- Since it is a maven project, we use maven to build and generate jar file, the version we used is 3.3
- To make the executable jar, we added a maven plugin with our correct main class path. So to get the jar file just run: 'mvn clean package' command.
- After the command, the jar will be created in the target folder under the name: 'expedia-test-project-0.0.1-SNAPSHOT.jar'

Deployment run:
---------------

As mentionned in 'How to generate the jar file' section, a java 1.8 version is required.
To run the jar file, just run: 'java -jar expedia-test-project-0.0.1-SNAPSHOT.jar'
