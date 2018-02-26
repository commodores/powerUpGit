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

	public CommandGroupAuto(Position position, Goal goal, Crosser crosser) {
		// Get the state of the switches and scale for each round
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		// make sure everything is in the right state/position here

		switch (position) {
		case LEFT:
			switch (goal) {
			case CROSS_LINE:
				addSequential(new autoFwdCrossLine());
				break;
			case SWITCH:
				switch (crosser) {
				case DO_NOT_CROSS:
					if (gameData.charAt(0) == 'L') {
						// when the switch is on the left
						addSequential(new autoFwdSwitch());
						addParallel(new turnRight90());
						addSequential(new elevatorUpSwitchAuto());
						addSequential(new intakeOutAuto());
					} else {
						// When the switch is on the right
						addSequential(new autoFwdCrossLine());
					}
					break;
				case CROSS:
					if (gameData.charAt(0) == 'L') {
						// when the switch is on the left
						addSequential(new autoFwdSwitch());
						addParallel(new turnRight90());
						addSequential(new elevatorUpSwitchAuto());
						addSequential(new intakeOutAuto());
					} else {
						// When the switch is on the right
						addSequential(new autoFwdCrossSwitch());
						addSequential(new turnRight90());
						addSequential(new autoFwdCrossFieldSwitch());
						addParallel(new turnLeft90());
						addSequential(new elevatorUpSwitchAuto());
						addSequential(new autoForward12());
						addSequential(new intakeOutAuto());
					}
					break;
				}
				break;
			case SCALE:
				switch (crosser) {
				case DO_NOT_CROSS:
					if (gameData.charAt(1) == 'L') {
						// when the scale is on the left
						addParallel(new elevatorUpScaleAuto());
						addSequential(new autoFwdScale());
						addSequential(new turnRight90());
						addSequential(new intakeOutAuto());
					} else {
						// When the scale is on the right
						addSequential(new autoFwdCrossLine());
					}
					break;
				case CROSS:
					if (gameData.charAt(1) == 'L') {
						// when the scale is on the left
						addParallel(new elevatorUpScaleAuto());
						addSequential(new autoFwdScale());
						addSequential(new turnRight90());
						addSequential(new intakeOutAuto());
					} else {
						// When the scale is on the right
						addSequential(new autoFwdCrossScale());
						addSequential(new turnRight90());
						addParallel(new elevatorUpScaleAuto());
						addSequential(new autoFwdCrossFieldScale());
						addSequential(new turnLeft90());
						addSequential(new autoForward12());
						addSequential(new intakeOutAuto());
					}
					break;
				}
				break;
			}
			break;

		case CENTER:
			switch (goal) {
			case CROSS_LINE:
				addSequential(new autoFwdCrossLine());
				break;
			case SWITCH:
				if (gameData.charAt(0) == 'L') {
					// when the switch is on the left
					addSequential(new autoFwdCrossLine());
				} else {
					// When the switch is on the right
					addSequential(new autoFwdCrossLine());
					addSequential(new elevatorUpSwitchAuto());
					addSequential(new intakeOutAuto());
				}
				break;
			case SCALE:
				if (gameData.charAt(1) == 'L') {
					// when the scale is on the left
					addSequential(new autoFwdCrossLine());
				} else {
					// When the scale is on the right
					addSequential(new autoFwdCrossLine());
				}
				break;
			}
			break;

		case RIGHT:
			switch (goal) {
			case CROSS_LINE:
				addSequential(new autoFwdCrossLine());
				break;
			case SWITCH:
				switch (crosser) {
				case DO_NOT_CROSS:
					if (gameData.charAt(0) == 'R') {
						// when the switch is on the right
						addSequential(new autoFwdSwitch());
						addParallel(new turnLeft90());
						addSequential(new elevatorUpSwitchAuto());
						addSequential(new intakeOutAuto());
					} else {
						// When the switch is on the left
						addSequential(new autoFwdCrossLine());
					}
					break;
				case CROSS:
					if (gameData.charAt(0) == 'R') {
						// when the switch is on the right
						addSequential(new autoFwdSwitch());
						addParallel(new turnLeft90());
						addSequential(new elevatorUpSwitchAuto());
						addSequential(new intakeOutAuto());
					} else {
						// When the switch is on the left
						addSequential(new autoFwdCrossSwitch());
						addSequential(new turnLeft90());
						addSequential(new autoFwdCrossFieldSwitch());
						addParallel(new turnRight90());
						addSequential(new elevatorUpSwitchAuto());
						addSequential(new autoForward12());
						addSequential(new intakeOutAuto());
					}
					break;
				}
				break;
			case SCALE:
				switch (crosser) {
				case DO_NOT_CROSS:
					if (gameData.charAt(1) == 'R') {
						// when the scale is on the right
						addParallel(new elevatorUpScaleAuto());
						addSequential(new autoFwdScale());
						addSequential(new turnLeft90());
						addSequential(new intakeOutAuto());
					} else {
						// When the scale is on the left
						addSequential(new autoFwdCrossLine());
					}
					break;
				case CROSS:
					if (gameData.charAt(1) == 'R') {
						// when the scale is on the right
						addParallel(new elevatorUpScaleAuto());
						addSequential(new autoFwdScale());
						addSequential(new turnLeft90());
						addSequential(new intakeOutAuto());
					} else {
						// When the scale is on the left
						addSequential(new autoFwdCrossScale());
						addSequential(new turnLeft90());
						addParallel(new elevatorUpScaleAuto());
						addSequential(new autoFwdCrossFieldScale());
						addSequential(new turnRight90());
						addSequential(new autoForward12());
						addSequential(new intakeOutAuto());
					}
					break;
				}
				break;
			}
			break;
		}
	}
}