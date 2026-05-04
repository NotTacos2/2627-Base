package org.firstinspires.ftc.teamcode.common;

import dev.nextftc.hardware.impl.MotorEx;

public class Parts {
    public static MotorEx FR, FL, BR, BL;
    public static MotorEx intake;

    public Parts() {
        FL = new MotorEx("lf").reversed().brakeMode();
        FR = new MotorEx("rf").brakeMode();
        BR = new MotorEx("rr").brakeMode();
        BL = new MotorEx("lr").reversed().brakeMode();
        intake = new MotorEx("intake").floatMode();
    }
}
