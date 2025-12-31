package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoCmd extends SequentialCommandGroup {
  public AutoCmd(DriveSubsystem driveSubsystem, ShooterSubsystem shooterSubsystem) {
    addCommands(
      new MoveForwardCmd(driveSubsystem).withTimeout(4.0),
      new ShootOutCmd(shooterSubsystem).withTimeout(1.5)
    );
  }
}
