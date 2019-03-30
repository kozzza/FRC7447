/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ArmManualRotationCommand;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class ArmRotation extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public WPI_VictorSPX rightArmMotor = new WPI_VictorSPX(RobotMap.rightArmMotor);
  public WPI_VictorSPX leftArmMotor = new WPI_VictorSPX(RobotMap.leftArMotor);

  public void turn(double percentVoltage) {
    rightArmMotor.set(ControlMode.PercentOutput, percentVoltage);
    leftArmMotor.set(ControlMode.PercentOutput, percentVoltage * -1);
    //ControlMode.PercentOutput means the next var (percentVoltage) tells it how much percent voltage to give the motor
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ArmManualRotationCommand());
  }
}
