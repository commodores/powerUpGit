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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.analog.adis16448.frc.ADIS16448_IMU;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static WPI_TalonSRX driveTrainleftFrontMotor;
    public static WPI_TalonSRX driveTrainleftRearMotor;
    public static SpeedControllerGroup driveTrainleftMotors;
    public static WPI_TalonSRX driveTrainrightFrontMotor;
    public static WPI_TalonSRX driveTrainrightRearMotor;
    public static SpeedControllerGroup driveTrainrightMotors;
    public static DifferentialDrive driveTraindifferentialDrive;
    public static Encoder driveTrainleftEncoder;
    public static SpeedController intakeleftIntakeMotor;
    public static SpeedController intakerightIntakeMotor;
    public static SpeedControllerGroup intakeintakeMotors;
    public static DigitalInput elevatorelevatorUpLimit;
    public static DigitalInput elevatorelevatorDownLimit;
    public static SpeedController elevatorelevatorMotor;
    public static SpeedController elevatorservo1;
    public static SpeedController elevatorservo2;
    public static SpeedController elevatorservo3;
    public static SpeedControllerGroup elevatorraiseServos;
    public static SpeedController ledControllerrevBlinkin;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static ADIS16448_IMU driveTrainimu;
    //public static ADXRS450_Gyro driveTrainGyro;
    

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainleftFrontMotor = new WPI_TalonSRX(0);
        
        
        driveTrainleftRearMotor = new WPI_TalonSRX(1);
        
        
        driveTrainleftMotors = new SpeedControllerGroup(driveTrainleftFrontMotor, driveTrainleftRearMotor  );
        LiveWindow.addActuator("driveTrain", "leftMotors", driveTrainleftMotors);
        
        driveTrainrightFrontMotor = new WPI_TalonSRX(3);
        
        
        driveTrainrightRearMotor = new WPI_TalonSRX(2);
        
        
        driveTrainrightMotors = new SpeedControllerGroup(driveTrainrightFrontMotor, driveTrainrightRearMotor  );
        LiveWindow.addActuator("driveTrain", "rightMotors", driveTrainrightMotors);
        
        driveTraindifferentialDrive = new DifferentialDrive(driveTrainleftMotors, driveTrainrightMotors);
        LiveWindow.addActuator("driveTrain", "differentialDrive", driveTraindifferentialDrive);
        driveTraindifferentialDrive.setSafetyEnabled(false);
        driveTraindifferentialDrive.setExpiration(0.1);
        driveTraindifferentialDrive.setMaxOutput(1.0);

        driveTrainleftEncoder = new Encoder(0, 1, true, EncodingType.k4X);
        LiveWindow.addSensor("driveTrain", "leftEncoder", driveTrainleftEncoder);
        driveTrainleftEncoder.setDistancePerPulse(0.053333);
        driveTrainleftEncoder.setPIDSourceType(PIDSourceType.kRate);
        intakeleftIntakeMotor = new Spark(2);
        LiveWindow.addActuator("intake", "leftIntakeMotor", (Spark) intakeleftIntakeMotor);
        intakeleftIntakeMotor.setInverted(true);
        intakerightIntakeMotor = new Spark(1);
        LiveWindow.addActuator("intake", "rightIntakeMotor", (Spark) intakerightIntakeMotor);
        intakerightIntakeMotor.setInverted(false);
        intakeintakeMotors = new SpeedControllerGroup(intakeleftIntakeMotor, intakerightIntakeMotor  );
        LiveWindow.addActuator("intake", "intakeMotors", intakeintakeMotors);
        
        elevatorelevatorUpLimit = new DigitalInput(3);
        LiveWindow.addSensor("elevator", "elevatorUpLimit", elevatorelevatorUpLimit);
        
        elevatorelevatorDownLimit = new DigitalInput(2);
        LiveWindow.addSensor("elevator", "elevatorDownLimit", elevatorelevatorDownLimit);
        
        elevatorelevatorMotor = new Spark(0);
        LiveWindow.addActuator("elevator", "elevatorMotor", (Spark) elevatorelevatorMotor);
        elevatorelevatorMotor.setInverted(false);
        elevatorservo1 = new Spark(4);
        LiveWindow.addActuator("elevator", "servo1", (Spark) elevatorservo1);
        elevatorservo1.setInverted(false);
        elevatorservo2 = new Spark(5);
        LiveWindow.addActuator("elevator", "servo2", (Spark) elevatorservo2);
        elevatorservo2.setInverted(false);
        elevatorservo3 = new Spark(3);
        LiveWindow.addActuator("elevator", "servo3", (Spark) elevatorservo3);
        elevatorservo3.setInverted(false);
        elevatorraiseServos = new SpeedControllerGroup(elevatorservo1, elevatorservo2  );
        LiveWindow.addActuator("elevator", "raiseServos", elevatorraiseServos);
        
        ledControllerrevBlinkin = new Spark(6);
        LiveWindow.addActuator("ledController", "revBlinkin", (Spark) ledControllerrevBlinkin);
        ledControllerrevBlinkin.setInverted(false);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        driveTrainimu = new ADIS16448_IMU();
        //driveTrainGyro = new ADXRS450_Gyro();
    }
}
