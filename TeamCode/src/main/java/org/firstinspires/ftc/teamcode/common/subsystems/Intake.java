package org.firstinspires.ftc.teamcode.common.subsystems;

import dev.nextftc.core.subsystems.Subsystem;
import org.firstinspires.ftc.teamcode.common.Parts;
import org.firstinspires.ftc.teamcode.common.Constants.*;

public class Intake implements Subsystem {
    public static final Intake INSTANCE = new Intake();
    private Intake() {}

    public enum IntakeMode{
        OFF,
        ON,
        REVERSE
    }
    public static IntakeMode mode = IntakeMode.OFF;

    @Override
    public void periodic() {
        switch (mode){
            case OFF:
                Parts.intake.setPower(0);
                break;
            case ON:
                Parts.intake.setPower(IntakeConstants.intakepower);
                break;
            case REVERSE:
                Parts.intake.setPower(IntakeConstants.reverseintakepower);
                break;
            default:
                mode = IntakeMode.OFF; // just in case
        }
    }
}