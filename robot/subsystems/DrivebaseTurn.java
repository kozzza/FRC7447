/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DrivebaseTurn extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // motor control objects
  public WPI_VictorSPX leftMaster = new WPI_VictorSPX(RobotMap.leftMaster);
  public WPI_VictorSPX leftSlave = new WPI_VictorSPX(RobotMap.leftSlave);
  public WPI_VictorSPX rightMaster  = new WPI_VictorSPX(RobotMap.rightMaster);
  public WPI_VictorSPX rightSlave  = new WPI_VictorSPX(RobotMap.rightSlave);

  // differentialdrive object
  public DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);

  public DrivebaseTurn(){
      leftSlave.follow(leftMaster);
      rightSlave.follow(rightMaster);
  }
  // driving with joy stick
  // move is y-axis (up and down) and turn is x-axis (left and right)
  public void maunalDrive(double move, double turn) {
    drive.arcadeDrive(move, turn);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    //setDefaultCommand(new DriveManuallyCommand());
  }
}