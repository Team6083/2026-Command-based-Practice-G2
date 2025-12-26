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

public class ClimberSubsystem extends SubsystemBase {

  private WPI_VictorSPX climberMotor = new WPI_VictorSPX(22);
  private DigitalInput limitSwitch = new DigitalInput(1);
  private DutyCycleEncoder encoder = new DutyCycleEncoder(0, 360, 0);
  private PIDController pidDown = new PIDController(0.02, 0, 0);
  private PIDController pidUp = new PIDController(0.02, 0, 0);
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
