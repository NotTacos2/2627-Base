package org.firstinspires.ftc.teamcode.common;

import dev.nextftc.hardware.impl.Direction;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.impl.IMUEx;

public class Parts {
    public static MotorEx FR, FL, BR, BL;
    public static MotorEx intake;
    public static IMUEx imu;

    public Parts() {
        FL = new MotorEx("lf").reversed().brakeMode();
        FR = new MotorEx("rf").brakeMode();
        BR = new MotorEx("rr").brakeMode();
        BL = new MotorEx("lr").reversed().brakeMode();
        imu = new IMUEx("imu", Direction.UP, Direction.RIGHT).zeroed();
        intake = new MotorEx("intake").floatMode();
    }
}
