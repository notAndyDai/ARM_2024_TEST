// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.ControlRequest;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */

  private TalonFX armMotor;
  private DigitalInput lSwitch;
  private DutyCycleOut request = new DutyCycleOut(0);

  public Arm() {
    armMotor = new TalonFX(1);
    lSwitch = new DigitalInput(0);
  }

  public void setPositionProfiled(){

  }

  public void setPower(double power){
    armMotor.setControl(request.withOutput(power));
  }

  public boolean getSwitch(){
    return !lSwitch.get();
  }

  public void resetArmPosition(double pos){
    armMotor.setPosition(pos);
  }

  public double getArmPosition(){
    return armMotor.getPosition().getValue();
  }


}
