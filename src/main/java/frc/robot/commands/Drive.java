// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.TankDrive;

public class Drive extends CommandBase {

  private TankDrive tankDrive;
  private CommandJoystick joystickLeft;
  private CommandJoystick joystickRight;

  /** Creates a new Drive. */
  public Drive(TankDrive tankDrive, CommandJoystick joystickLeft, CommandJoystick joystickRight) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.tankDrive = tankDrive;
    this.joystickLeft = joystickLeft;
    this.joystickRight = joystickRight;
    
    addRequirements(tankDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    tankDrive.setMaxOutput(0.9);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    tankDrive.diffDrive(joystickLeft.getY(), joystickRight.getY());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
