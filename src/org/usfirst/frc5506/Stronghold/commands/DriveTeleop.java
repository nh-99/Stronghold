// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5506.Stronghold.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5506.Stronghold.Robot;

/**
 *
 */
public class DriveTeleop extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveTeleop() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }
    
    private double curveDuration = 25; // duration of curve in frames (frame = 20ms)
    private double currentTime = 0;
    
    private double stepCurve() {
    	if (currentTime < curveDuration) {
    		currentTime++;
    		return (currentTime / curveDuration) * (currentTime / curveDuration) * (currentTime / curveDuration);
    	} else {
    		return 1;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double joystickSpeed = Robot.oi.getDriverJoystick().getY() * -1;
    	double turningSpeed = Robot.oi.getDriverJoystick().getX() * -1;
    	if (Math.abs(joystickSpeed) >= 0.1) {
    		Robot.driveTrain.drive(stepCurve() * joystickSpeed, turningSpeed);
    	} else {
    		currentTime = 0;
    		Robot.driveTrain.drive(0, 0);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
