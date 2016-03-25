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
public class ScalingTeleop extends Command {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ScalingTeleop() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.scalingArm);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean turretA = Robot.oi.getFunctionJoystick().getRawButton(9);
    	boolean turretB = Robot.oi.getFunctionJoystick().getRawButton(10);
    	boolean extend = Robot.oi.getFunctionJoystick().getRawButton(11);
    	boolean retract = Robot.oi.getFunctionJoystick().getRawButton(12);
    	double turretSpeed = 0;
    	double extendSpeed = 0;
    	if (turretA)
    		turretSpeed += (Robot.oi.getFunctionJoystick().getRawAxis(3) + 1) / 2;
    	if (turretB)
    		turretSpeed -= (Robot.oi.getFunctionJoystick().getRawAxis(3) + 1) / 2;
    	if (extend)
    		extendSpeed += (Robot.oi.getFunctionJoystick().getRawAxis(3) + 1) / 2;
    	if (retract)
    		extendSpeed -= (Robot.oi.getFunctionJoystick().getRawAxis(3) + 1) / 2;
    	Robot.scalingArm.setExtendSpeed(extendSpeed);
    	Robot.scalingArm.setTurretSpeed(turretSpeed);
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
