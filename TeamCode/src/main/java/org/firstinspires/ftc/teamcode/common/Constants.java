package org.firstinspires.ftc.teamcode.common;

import com.bylazar.configurables.annotations.Configurable;

public class Constants {
    @Configurable
    public static class IntakeConstants {
        public static double intakepower = 1;
        public static double reverseintakepower = -1;
    }
    @Configurable
    public static class DriveConstants {
        public static double slowdrivepower = 0.5;
    }
}
