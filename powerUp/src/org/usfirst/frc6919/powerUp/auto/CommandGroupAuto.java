package org.usfirst.frc6919.powerUp.auto;

import edu.wpi.first.wpilibj.DriverStation;
import org.usfirst.frc6919.powerUp.Constants;
import org.usfirst.frc6919.powerUp.Robot;
import org.usfirst.frc6919.powerUp.commands.*; // when the commands are ready, load each individually to decrease runtime
import org.usfirst.frc6919.powerUp.enumeration.Goal;
import org.usfirst.frc6919.powerUp.enumeration.Position;

import edu.wpi.first.wpilibj.command.CommandGroup;

/** the sequence of commands for autonomous */
public class CommandGroupAuto extends CommandGroup {

	//Stores the states of the switches and scale
	String gameData;

	public CommandGroupAuto(Position position, Goal goal) {
		//Get the state of the switches and scale for each round
		gameData = DriverStation.getInstance().getGameSpecificMessage();

		// make sure everything is in the right state/position here

		switch (position) {
			case LEFT:
				switch (goal){
					case CROSS_LINE:
						addSequential(new autoForward108());
						break;
					case SWITCH:
						if (gameData.charAt(0) == 'L'){
							//when the switch is on the left
							addSequential(new autoForward156());
							addSequential(new turnRight90());
							addSequential(new elevatorUpSwitchAuto());
							addSequential(new intakeOutAuto());
						} else {
							//When the switch is on the right
							addSequential(new autoForward108());
						}
						break;
					case SCALE:
						if (gameData.charAt(1) == 'L'){
							//when the scale is on the left
							addSequential(new autoForward324());
							addSequential(new turnRight90());
							addSequential(new autoReverse12());
							addSequential(new elevatorUpScaleAuto());
							addSequential(new intakeOutAuto());
						} else {
							//When the scale is on the right
							addSequential(new autoForward108());
						}
						break;
				}
				break;

			case CENTER:
				switch (goal){
					case CROSS_LINE:
						addSequential(new autoForward108());
						break;
					case SWITCH:
						if (gameData.charAt(0) == 'L'){
							//when the switch is on the left
							addSequential(new autoForward108());
						} else {
							//When the switch is on the right
							addSequential(new autoForward108());
							addSequential(new elevatorUpSwitchAuto());
							addSequential(new intakeOutAuto());
						}
						break;
					case SCALE:
						if (gameData.charAt(1) == 'L'){
							//when the scale is on the left
							addSequential(new autoForward108());
						} else {
							//When the scale is on the right
							addSequential(new autoForward108());
						}
						break;
			}
				break;
				
			case RIGHT:
				switch (goal) {
					case CROSS_LINE:
						addSequential(new autoForward108());
						break;
					case SWITCH:
						if (gameData.charAt(0) == 'L'){
							//when the switch is on the left
							addSequential(new autoForward108());
						} else {
							//When the switch is on the right
							addSequential(new autoForward156());
							addSequential(new turnLeft90());
							addSequential(new elevatorUpSwitchAuto());
							addSequential(new intakeOutAuto());
						}
						break;
					case SCALE:
						if (gameData.charAt(1) == 'L'){
							//when the scale is on the left
							addSequential(new autoForward108());
						} else {
							//When the scale is on the right
							addSequential(new autoForward324());
							addSequential(new turnLeft90());
							addSequential(new autoReverse12());
							addSequential(new elevatorUpScaleAuto());
							addSequential(new intakeOutAuto());
						}
						break;
				}
			break;
		}	
	}
}