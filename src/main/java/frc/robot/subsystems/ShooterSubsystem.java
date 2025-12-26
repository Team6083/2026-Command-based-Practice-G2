package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final WPI_VictorSPX shooterMotor;

  public ShooterSubsystem() {
    shooterMotor = new WPI_VictorSPX(Constants.ShooterConstants.SHOOTER_MOTOR_ID);
  }

  public void shootOut() {
    shooterMotor.set(Constants.ShooterConstants.SHOOTER_SPEED);
  }

  public void shootIn() {
    shooterMotor.set(-(Constants.ShooterConstants.SHOOTER_SPEED));
  }

  public void stop() {
    shooterMotor.set(0);
  }
    
}
