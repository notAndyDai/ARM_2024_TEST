// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.HomeArm;
import frc.robot.loops.ArmLoop;
import frc.robot.util.OI;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private ArmLoop arm;
  private OI oi;

  private Trigger homeTrigger;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    arm = ArmLoop.getInstance();
    oi = OI.getInstance();

    homeTrigger = new Trigger(() -> oi.getDriveAButton());

    homeTrigger.onTrue(new HomeArm());
  }

  public void stopArm(){
    arm.setPower(0);
  }
}
