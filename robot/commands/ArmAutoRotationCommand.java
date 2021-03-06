
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.Robot;

public class ArmAutoRotationCommand extends Command {
    public int direction;
    public ArmAutoRotationCommand() {
        direction = -1;
        requires(Robot.armRotation);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setTimeout(2.5);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        //System.out.println(direction);
        Robot.armRotation.turn(0.325 * direction);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        direction *= -1;
        
        if (direction == 1) {
            Shuffleboard.selectTab("CameraUp");
        } else {
            Shuffleboard.selectTab("CameraDown");
        }

        Robot.armRotation.turn(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}