// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6919.powerUp;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc6919.powerUp.commands.*;
import org.usfirst.frc6919.powerUp.subsystems.*;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;

import org.usfirst.frc6919.powerUp.auto.CommandGroupAuto;
import org.usfirst.frc6919.powerUp.enumeration.Goal;
import org.usfirst.frc6919.powerUp.enumeration.Position;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in 
 * the project.
 */
public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();
    CameraServer server;
    
    //choosers
    SendableChooser<Goal> goalChooser;
    SendableChooser<Position> positionChooser;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static driveTrain driveTrain;
    public static intake intake;
    public static elevator elevator;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private CommandGroupAuto auto;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit() {
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrain = new driveTrain();
        intake = new intake();
        elevator = new elevator();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
      /// instantiate position chooser
		positionChooser = new SendableChooser<>();
		positionChooser.addDefault(Position.LEFT.toString(), Position.LEFT); // set default to nothing
		for(int i = 1; i < Position.values().length; i++) { 
			positionChooser.addObject(Position.values()[i].toString(), Position.values()[i]); } // add each autonomous enum value to chooser
		SmartDashboard.putData("Position", positionChooser); //display the chooser on the dash
		
		/// instantiate goal chooser
		goalChooser = new SendableChooser<>();
		goalChooser.addDefault("Just Cross Line", Goal.CROSS_LINE); // set default to Switch
		for(int i = 1; i < Goal.values().length; i++) { 
			goalChooser.addObject(Goal.values()[i].toString(), Goal.values()[i]); } // add each autonomous enum value to chooser
		SmartDashboard.putData("Goal", goalChooser); //display the chooser on the dash
        
        server=CameraServer.getInstance();
        server.startAutomaticCapture(0);
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    @Override
    public void disabledInit(){
    	DriverStation.reportWarning("TELEOP IS DISABLED", false);
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
    	DriverStation.reportWarning("AUTONOMOUS IS STARTING...", false);
        
    	if(goalChooser.getSelected() != null) {
			auto = new CommandGroupAuto(positionChooser.getSelected(), goalChooser.getSelected());
			auto.start(); 
		}
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
