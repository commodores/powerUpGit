// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6919.powerUp.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6919.powerUp.Robot;

/**
 *
 */
public class autoFwdCrossDanceLine extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public autoFwdCrossDanceLine() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        setTimeout(10.0);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    	//Reset Sensors
    	Robot.driveTrain.resetEncoder();
    	Robot.driveTrain.resetIMU();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	double pTerm = Robot.driveTrain.driveTrainGain * (0.0 - Robot.driveTrain.getIMUAngle());
    	Robot.driveTrain.drive(.625 + pTerm, .625 - pTerm);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.driveTrain.getEncoderDistance() > 108 || isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	end();
    }
}
