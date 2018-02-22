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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

/**
 *
 */
public class driveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final WPI_TalonSRX leftFrontMotor = RobotMap.driveTrainleftFrontMotor;
    private final WPI_TalonSRX leftRearMotor = RobotMap.driveTrainleftRearMotor;
    private final SpeedControllerGroup leftMotors = RobotMap.driveTrainleftMotors;
    private final WPI_TalonSRX rightFrontMotor = RobotMap.driveTrainrightFrontMotor;
    private final WPI_TalonSRX rightRearMotor = RobotMap.driveTrainrightRearMotor;
    private final SpeedControllerGroup rightMotors = RobotMap.driveTrainrightMotors;
    private final DifferentialDrive differentialDrive = RobotMap.driveTraindifferentialDrive;
    private final Encoder leftEncoder = RobotMap.driveTrainleftEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    private final ADIS16448_IMU imu = RobotMap.driveTrainimu;
    //private final ADXRS450_Gyro gyro = RobotMap.driveTrainGyro;
    
    public final double driveTrainGain = .05;
    
    public final float cubicConstant = (float) 0.07;

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new driveManual());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
    
    public void takeJoystickInputs(float left, float right) {
    	
    	float cubedLeft = cubicScale(left);
    	float cubedRight = cubicScale(right);
    	
    	differentialDrive.tankDrive(cubedLeft, cubedRight);
    }
    
    private float cubicScale(float arg){
    	float a;
    	a = (float) (cubicConstant*arg + (1-cubicConstant)*Math.pow((double)arg, 3));
    	return a;
    }
    
    public void drive(double left, double right) {
    	differentialDrive.tankDrive(left, right);
    }
    
    public void stop() {
    	differentialDrive.stopMotor();
    }
    
    public double getEncoderDistance() {
    	return leftEncoder.getDistance();
    }
    
    public void resetEncoder() {
    	leftEncoder.reset();
    }
    
    public double getIMUAngle() {
    	return imu.getAngleZ();
    	//return gyro.getAngle();
    }
    
    public void resetIMU() {
    	imu.reset();
    	//gyro.reset();
    }
}

