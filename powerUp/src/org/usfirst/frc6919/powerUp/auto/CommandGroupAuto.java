package org.usfirst.frc6919.powerUp.auto;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc6919.powerUp.Robot;
import org.usfirst.frc6919.powerUp.commands.*; // when the commands are ready, load each individually to decrease runtime
import org.usfirst.frc6919.powerUp.enumeration.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** the sequence of commands for autonomous */
public class CommandGroupAuto extends CommandGroup {

	// Stores the states of the switches and scale
	String gameData;

	public CommandGroupAuto(Position position) {
		// Get the state of the switches and scale for each round
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		// make sure everything is in the right state/position here

		switch (position) {
		case LEFT:
			if (gameData.charAt(0) == 'L') {
				addParallel(new elevatorUpSwitchAuto());
				addSequential(new autoFwdLeftSwitch());
				addSequential(new intakeOutAuto());
			} else if (gameData.charAt(1) == 'L') {
				addParallel(new elevatorUpScaleAuto());
				addSequential(new autoFwdLeftScale());
				addSequential(new autoFwdRight45());
				addSequential(new autoChill());
				addSequential(new intakeOutAuto());
			} else { //DANCE!!
				addSequential(new autoFwdCrossDanceLine());
				addSequential(new autoChill());
				addSequential(new autoBackUpSome());
				addSequential(new autoChill());
				addSequential(new turnLeft90());
				addSequential(new autoChill());
				addSequential(new turnRight90());
				addSequential(new turnRight90());
				addSequential(new autoChill());
				addParallel(new elevatorUpSwitchAuto());
				addSequential(new turnLeft90());
				addSequential(new turnLeft90());
				addSequential(new turnLeft90());
				addSequential(new autoChill());
				addSequential(new autoBackUpSome());
			}
			break;
		case RIGHT:
			if (gameData.charAt(0) == 'R') {
				addParallel(new elevatorUpSwitchAuto());
				addSequential(new autoFwdRightSwitch());
				addSequential(new intakeOutAuto());
			} else if (gameData.charAt(1) == 'R') {
				addParallel(new elevatorUpScaleAuto());
				addSequential(new autoFwdRightScale());
				addSequential(new autoFwdLeft45());
				addSequential(new autoChill());
				addSequential(new intakeOutAuto());
			} else { //DANCE!!
				addSequential(new autoFwdCrossDanceLine());
				addSequential(new autoChill());
				addSequential(new autoBackUpSome());
				addSequential(new autoChill());
				addSequential(new turnLeft90());
				addSequential(new autoChill());
				addSequential(new turnRight90());
				addSequential(new turnRight90());
				addSequential(new autoChill());
				addParallel(new elevatorUpSwitchAuto());
				addSequential(new turnLeft90());
				addSequential(new turnLeft90());
				addSequential(new turnLeft90());
				addSequential(new autoChill());
				addSequential(new autoBackUpSome());
			}			
			break;
		case CENTER:
			if (gameData.charAt(0) == 'R') {
				addParallel(new elevatorUpSwitchAuto());
				addSequential(new autoFwdCrossLine());
				addSequential(new intakeOutAuto());
			} else {
				addParallel(new elevatorUpSwitchAuto());
				addSequential(new autoLeftCurve());
				addSequential(new autoCenterCross());
				addSequential(new autoRightScore());
				addSequential(new autoLeftScoreFwd());
				addSequential(new intakeOutAuto());
			}
			break;
		case DANCE_PARTY:
			addSequential(new autoFwdCrossDanceLine());
			addSequential(new autoChill());
			addSequential(new autoBackUpSome());
			addSequential(new autoChill());
			addSequential(new turnLeft90());
			addSequential(new autoChill());
			addSequential(new turnRight90());
			addSequential(new turnRight90());
			addSequential(new autoChill());
			addParallel(new elevatorUpSwitchAuto());
			addSequential(new turnLeft90());
			addSequential(new turnLeft90());
			addSequential(new turnLeft90());
			addSequential(new autoChill());
			addSequential(new autoBackUpSome());
		}
	}
}