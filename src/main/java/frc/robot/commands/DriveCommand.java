package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;


public class DriveCommand extends Command {
    private final DriveSubsystem drive;
    private final Joystick joystick;

    public DriveCommand(DriveSubsystem drive, Joystick joystick) {
        this.drive = drive;
        this.joystick = joystick;
        addRequirements(drive);
     }

    @Override
    public void execute() {
        double right = joystick.getRawAxis(5) * 0.3;
        double left  = joystick.getRawAxis(1) * -0.3;

        drive.drive(left, right);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }
}
