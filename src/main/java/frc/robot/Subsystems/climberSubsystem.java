// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
public class ClimberSubsystem extends SubsystemBase {

  private WPI_VictorSPX climberMotor = new WPI_VictorSPX(Constants.ClimberConstants.CLIMBER_MOTOR_ID);
  private DigitalInput limitSwitch = new DigitalInput(Constants.ClimberConstants.DIGITALINPUT_ID);
  private DutyCycleEncoder encoder = new DutyCycleEncoder(Constants.ClimberConstants.DUTYCYCLEENCODER_ID, Constants.ClimberConstants.DUTYCYCLEENCODER_FULLRANGE,  Constants.ClimberConstants.DUTYCYCLEENCODER_EXPECTEDZERO);  
  private PIDController pidDown = new PIDController(Constants.ClimberConstants.PIDCONTROLLER_DOWN_KP, Constants.ClimberConstants.PIDCONTROLLER_DOWN_KI, Constants.ClimberConstants.PIDCONTROLLER_DOWN_KD);
  private PIDController pidUp = new PIDController(Constants.ClimberConstants.PIDCONTROLLER_UP_KP, Constants.ClimberConstants.PIDCONTROLLER_UP_KI, Constants.ClimberConstants.PIDCONTROLLER_UP_KD);
  private double setpoint;
  /** Creates a new climberSubsystem. */
  public ClimberSubsystem() {
    pidUp.enableContinuousInput(0,360);
    pidDown.enableContinuousInput(0,360);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void reset(){
    pidUp.reset();
    pidDown.reset();
  }
  
  public void deepCageDown(){
    setpoint = 90.0;
    double currentPosition = encoder.get();
    double output = -(pidDown.calculate(currentPosition, setpoint));
    climberMotor.set(ControlMode.PercentOutput, MathUtil.clamp(output, -0.2, 0.2));
  }

  public void deepCageUp(){
    boolean retractLimitPressed = limitSwitch.get(); 
    if (retractLimitPressed) {
      climberMotor.set(ControlMode.PercentOutput, 0);
      pidUp.reset();
      return;
    } 

    setpoint = 0.0;
    double currentPosition = encoder.get();
    double output = -(pidUp.calculate(currentPosition, setpoint));
    climberMotor.set(ControlMode.PercentOutput, MathUtil.clamp(output, -0.2, 0.2));
  }

  public void stop(){
    climberMotor.set(ControlMode.PercentOutput,0);
  }



}
