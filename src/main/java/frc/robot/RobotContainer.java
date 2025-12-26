// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.ClimberDownCmd;
import frc.robot.commands.ClimberUpCmd;
import frc.robot.subsystems.ClimberSubsystem;

public class RobotContainer {
    CommandXboxController joy = new CommandXboxController(0);
    ClimberSubsystem climberSubsystem = new ClimberSubsystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    joy.x().onTrue(new ClimberUpCmd(climberSubsystem));
    joy.y().onTrue(new ClimberDownCmd(climberSubsystem));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
