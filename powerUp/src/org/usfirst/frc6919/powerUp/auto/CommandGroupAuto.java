package org.usfirst.frc6919.powerUp.auto;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc6919.powerUp.Robot;
import org.usfirst.frc6919.powerUp.commands.*; // when the commands are ready, load each individually to decrease runtime
import org.usfirst.frc6919.powerUp.enumeration.Goal;
import org.usfirst.frc6919.powerUp.enumeration.Position;
import org.usfirst.frc6919.powerUp.enumeration.Crosser;

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
				addSequential(new intakeOutAuto());
			} else {
				addSequential(new autoFwdCrossLine());
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
				addSequential(new intakeOutAuto());
			} else {
				addSequential(new autoFwdCrossLine());
			}			
			break;
		case CENTER:
			if (gameData.charAt(0) == 'R') {
				addParallel(new elevatorUpSwitchAuto());
				addSequential(new autoFwdCrossLine());
				addSequential(new intakeOutAuto());
			} else {
				addSequential(new autoFwdCrossLine());
			}
			break;
		}
	}
}