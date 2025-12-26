package frc.robot;

public final class Constants {
  // 驅動系統常數
  public static final class DriveConstants {
    public static final int LEADER_LEFT_ID = 34;
    public static final int FOLLOWER_LEFT_ID = 33;
    public static final int LEADER_RIGHT_ID = 31;
    public static final int FOLLOWER_RIGHT_ID = 32;
  }

  // 發射系統常數
  public static final class ShooterConstants {
    public static final int SHOOTER_MOTOR_ID = 21;
    public static final double SHOOTER_SPEED = 0.4;
  }

  // 攀爬系統常數
  public static final class ClimberConstants {
    public static final int CLIMBER_MOTOR_ID = 22;
    public static final int DIGITALINPUT_ID = 1;
    public static final int DUTYCYCLEENCODER_ID = 0;
    public static final double DUTYCYCLEENCODER_FULLRANGE = 360;
    public static final double DUTYCYCLEENCODER_EXPECTEDZERO = 0;
    public static final double PIDCONTROLLER_DOWN_KP = 0.02;
    public static final double PIDCONTROLLER_DOWN_KI = 0;
    public static final double PIDCONTROLLER_DOWN_KD = 0;
    public static final double PIDCONTROLLER_UP_KP = 0.02;
    public static final double PIDCONTROLLER_UP_KI = 0;
    public static final double PIDCONTROLLER_UP_KD = 0;

  }

  // 操作介面常數
  public static final class OperatorConstants {
    public static final int DRIVER_CONTROLLER_PORT = 0;
  }

  // 自動模式常數
  public static final class AutoConstants {
    public static final double AUTO_DRIVE_SPEED = 0.5;
  }
}