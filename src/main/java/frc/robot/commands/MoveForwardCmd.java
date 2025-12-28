package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;

public class MoveForwardCmd extends Command {

    DriveSubsystem driveSubsystem;
    
    public MoveForwardCmd(DriveSubsystem drive) {
      this.driveSubsystem = drive;
      addRequirements(drive);
    }

    @Override
    public void initialize() {
      
    }

    @Override
    public void execute() {
        driveSubsystem.moveForward();
    }
    
    @Override
    public void end(boolean interrupted) {
      
    }

    @Override
    public boolean isFinished() {
      return false;
    }
}

