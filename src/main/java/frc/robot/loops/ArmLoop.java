package frc.robot.loops;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Arm;

public class ArmLoop extends Arm {

    private static ArmLoop mInstance;

    public enum ArmState {
        HOMING,
        POSITION_PROFILED,
        DISABLED
    }

    private ArmState mArmState;

    public static ArmLoop getInstance() {
        if (mInstance == null) {
            mInstance = new ArmLoop();
        }
        return mInstance;
    }

    private ArmLoop() {
        mArmState = ArmState.DISABLED;
    }

    public void setState(ArmState state){
        mArmState = state;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Arm Position", getArmPosition());
        switch (mArmState) {
            case HOMING:
                this.homing();
                break;
            case POSITION_PROFILED:

                break;
            case DISABLED:
                this.stop();
                break;

            default:
                break;
        }
    }

    private void stop() {
        this.setPower(0);
    }

    private void homing() {
        this.setPower(-0.1);
    }

}
