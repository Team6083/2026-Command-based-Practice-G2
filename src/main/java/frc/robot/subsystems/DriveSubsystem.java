package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSubsystem extends SubsystemBase {

  private WPI_VictorSPX leaderRight = new WPI_VictorSPX(31);
  private WPI_TalonSRX  followerRight = new WPI_TalonSRX(32);

  private WPI_VictorSPX leaderLeft = new WPI_VictorSPX(34);
  private WPI_TalonSRX  followerLeft = new WPI_TalonSRX(33);

  public DriveSubsystem() {
    followerRight.follow(leaderRight);
    followerLeft.follow(leaderLeft);
  }

  public void drive(double left, double right) {
    leaderLeft.set(left);
    leaderRight.set(right);
  }

  public void stop() {
    drive(0, 0);
  }
}