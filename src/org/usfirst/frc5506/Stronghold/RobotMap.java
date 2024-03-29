// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.Stronghold;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainleftMotors;
    public static SpeedController driveTrainrightMotors;
    public static RobotDrive driveTrainmotors;
    public static Encoder driveTrainEncoder;
    public static SpeedController liftLiftMotor;
    public static SpeedController scalingArmrotateArm;
    public static SpeedController scalingArmextendArm;
    public static CANTalon launcherRetractLauncher;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainleftMotors = new Victor(0);
        LiveWindow.addActuator("DriveTrain", "leftMotors", (Victor) driveTrainleftMotors);
        
        driveTrainrightMotors = new Victor(1);
        LiveWindow.addActuator("DriveTrain", "rightMotors", (Victor) driveTrainrightMotors);
        
        driveTrainmotors = new RobotDrive(driveTrainleftMotors, driveTrainrightMotors);
        
        driveTrainmotors.setSafetyEnabled(true);
        driveTrainmotors.setExpiration(0.1);
        driveTrainmotors.setSensitivity(0.5);
        driveTrainmotors.setMaxOutput(1.0);

        driveTrainEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "Encoder", driveTrainEncoder);
        driveTrainEncoder.setDistancePerPulse(1.0);
        driveTrainEncoder.setPIDSourceType(PIDSourceType.kRate);
        liftLiftMotor = new Talon(4);
        LiveWindow.addActuator("Lift", "LiftMotor", (Talon) liftLiftMotor);
        
        scalingArmrotateArm = new Victor(2);
        LiveWindow.addActuator("ScalingArm", "rotateArm", (Victor) scalingArmrotateArm);
        
        scalingArmextendArm = new Victor(3);
        LiveWindow.addActuator("ScalingArm", "extendArm", (Victor) scalingArmextendArm);
        
        launcherRetractLauncher = new CANTalon(0);
        LiveWindow.addActuator("Launcher", "RetractLauncher", launcherRetractLauncher);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainEncoder.setDistancePerPulse(6.5 * Math.PI / Robot.driveTrainEncoderPulsesPerRotation);
    }
}
