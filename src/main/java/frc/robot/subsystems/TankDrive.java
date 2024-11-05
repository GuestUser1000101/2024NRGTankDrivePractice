// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.math.filter.SlewRateLimiter;

public class TankDrive extends SubsystemBase {
  
  private MotorController rightMotor1 = new VictorSP(0);
  private MotorController rightMotor2 = new VictorSP(1);

  private MotorController leftMotor1 = new VictorSP(2);
  private MotorController leftMotor2 = new VictorSP(3);

  private MotorControllerGroup rightMotorGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
  private MotorControllerGroup leftMotorGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

  private DifferentialDrive diffDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

  /** Creates a new TankDrive. */
  public TankDrive() {}

  public void diffDrive(double leftSpeed, double rightSpeed) {
    leftMotorGroup.setInverted(true);
    diffDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void setMaxOutput(double maxOutput) {
    diffDrive.setMaxOutput(maxOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
