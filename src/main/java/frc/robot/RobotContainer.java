// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ShootOutCmd;
import frc.robot.commands.ShootInCmd;
import frc.robot.subsystems.ShooterSubsystem;

public class RobotContainer {
  
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final CommandXboxController driverController = 
      new CommandXboxController(Constants.OperatorConstants.DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    driverController.a().whileTrue(new ShootOutCmd(shooterSubsystem));
    driverController.b().whileTrue(new ShootInCmd(shooterSubsystem));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}