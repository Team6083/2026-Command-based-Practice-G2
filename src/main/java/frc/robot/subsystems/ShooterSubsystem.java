package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class ShooterSubsystem extends SubsystemBase {

  private WPI_VictorSPX shooterMotor = new WPI_VictorSPX(21);
  

  public void shoot(double speed) {
    shooterMotor.set(speed);
  }

  public void stop() {
    shoot(0);
  }
    
}
