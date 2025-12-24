package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends Command {
    private final ShooterSubsystem shooter;
    private final Joystick joystick;

    public ShooterCommand(ShooterSubsystem shooter, Joystick joystick) {
        this.shooter = shooter;
        this.joystick = joystick;
        addRequirements(shooter);
    }

    @Override
    public void execute() {
        if (joystick.getRawButton(1)) {      
            shooter.shoot(0.2);
        } else if (joystick.getRawButton(2)) { 
            shooter.shoot(-0.2);
        } else {
            shooter.stop();
        }
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
