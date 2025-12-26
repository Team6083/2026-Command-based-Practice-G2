package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  WPI_VictorSPX leaderLeft = new WPI_VictorSPX(Constants.DriveConstants.LEADER_LEFT_ID); 
  WPI_TalonSRX followerLeft = new WPI_TalonSRX(Constants.DriveConstants.FOLLOWER_LEFT_ID); 
  WPI_VictorSPX leaderRight = new WPI_VictorSPX(Constants.DriveConstants.LEADER_RIGHT_ID);
  WPI_TalonSRX followerRight = new WPI_TalonSRX(Constants.DriveConstants.FOLLOWER_RIGHT_ID);

  public DriveSubsystem() {
    followerLeft.follow(leaderLeft);
    followerRight.follow(leaderRight);

    leaderRight.setInverted(true);
    followerRight.setInverted(true);
  }

  public void drive(double leftSpeed, double rightSpeed) {
    leaderLeft.set(leftSpeed);
    leaderRight.set(rightSpeed);
  }

  public void stop() {
    leaderLeft.set(0);
    leaderRight.set(0);
  }
}
