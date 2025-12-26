package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCmd extends Command {
  private DriveSubsystem driveSubsystem;
  private CommandXboxController controller;

  public DriveCmd(DriveSubsystem driveSubsystem, CommandXboxController controller) {
    this.driveSubsystem = driveSubsystem;
    this.controller = controller;
    addRequirements(driveSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double leftSpeed = controller.getLeftY();
    double rightSpeed = controller.getRightY();
    driveSubsystem.drive(leftSpeed, rightSpeed);
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
