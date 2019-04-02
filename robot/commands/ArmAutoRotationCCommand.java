
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

public class ArmAutoRotationCCommand extends Command {
    private static int armDirection = 1;
    private boolean finished;

    public ArmAutoRotationCCommand() {
        finished = false;
        
        requires(Robot.armRotation);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        armDirection *= -1;
        setTimeout(2.5);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        if (armDirection == -1) {
            if (isTimedOut()) {
                Robot.armRotation.turn(0.1);
            }
            else {
                Robot.armRotation.turn(0.35 * armDirection);
            }
        }
        else if (armDirection == 1) {
            if (isTimedOut()) {
                finished = true;
            }
            else {
                Robot.armRotation.turn(0.35 * armDirection);
            }
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return finished;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        if (armDirection == 1) {
            Shuffleboard.selectTab("CameraUp");
        }
        else {
            Shuffleboard.selectTab("CameraDown");
        }
        
        IntakeSpinCommand.intakeDirection *= -1;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
