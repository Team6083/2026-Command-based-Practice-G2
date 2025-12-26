// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ClimberDownCmd;
import frc.robot.commands.ClimberUpCmd;
import frc.robot.commands.DriveCmd;
import frc.robot.commands.ShootInCmd;
import frc.robot.commands.ShootOutCmd;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ClimberSubsystem;
    
    


public class RobotContainer {
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
  private final CommandXboxController driverController = 
      new CommandXboxController(Constants.OperatorConstants.DRIVER_CONTROLLER_PORT);

  public RobotContainer() {
    configureBindings();
    configureDefaultCommands();
  }

  private void configureBindings() {
    driverController.x().onTrue(new ClimberUpCmd(climberSubsystem));
    driverController.y().onTrue(new ClimberDownCmd(climberSubsystem));
    driverController.a().whileTrue(new ShootOutCmd(shooterSubsystem));
    driverController.b().whileTrue(new ShootInCmd(shooterSubsystem));
  }

  private void configureDefaultCommands() {
    driveSubsystem.setDefaultCommand(
        new DriveCmd(driveSubsystem, driverController));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}