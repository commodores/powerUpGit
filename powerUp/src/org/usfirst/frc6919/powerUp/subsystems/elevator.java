// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6919.powerUp.subsystems;

import org.usfirst.frc6919.powerUp.RobotMap;
import org.usfirst.frc6919.powerUp.commands.*;
import edu.wpi.first.wpilibj.command.Subsystem;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class elevator extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DigitalInput elevatorUpLimit = RobotMap.elevatorelevatorUpLimit;
    private final DigitalInput elevatorDownLimit = RobotMap.elevatorelevatorDownLimit;
    private final SpeedController elevatorMotor = RobotMap.elevatorelevatorMotor;
    private final SpeedController servo1 = RobotMap.elevatorservo1;
    private final SpeedController servo2 = RobotMap.elevatorservo2;
    private final SpeedControllerGroup raiseServos = RobotMap.elevatorraiseServos;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new intakeAngle());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
    
    public void elevatorManual(double direction) {
		elevatorMotor.set(direction);
    }

    public void elevatorUp() {
    		elevatorMotor.set(-1);
    }
    
    public void elevatorDown() {
    		elevatorMotor.set(1);
    }
    
    public void elevatorStop() {
    	elevatorMotor.stopMotor();
    }
    
    public boolean getUpLimit() {
    	return elevatorUpLimit.get();
    }
    
    public boolean getDownLimit() {
    	return elevatorDownLimit.get();
    }
    
    public void elevatorHold() {
    	elevatorMotor.set(-.08);
    }
    
    public void intakeAngle(double setPoint) {
    	raiseServos.set(setPoint);
    }

}

