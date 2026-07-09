package org.firstinspires.ftc.teamcode.opmodes;

import dev.nextftc.bindings.BindingManager;
import dev.nextftc.ftc.NextFTCOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.hardware.driving.DriverControlledCommand;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.hardware.driving.MecanumDriverControlled;

import org.firstinspires.ftc.teamcode.common.subsystems.Intake;
import org.firstinspires.ftc.teamcode.common.Parts;
import org.firstinspires.ftc.teamcode.common.Constants.*;

@TeleOp(group = "Decode")
public class TeleOP extends NextFTCOpMode {
    Parts part = new Parts();
    public TeleOP() {
        addComponents(
                new SubsystemComponent(Intake.INSTANCE),
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }

    @Override
    public void onStartButtonPressed() {
        DriverControlledCommand driverControlled = new MecanumDriverControlled(
                Parts.FL,
                Parts.FR,
                Parts.BL,
                Parts.BR,
                Gamepads.gamepad1().leftStickY().negate(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX()
        );
        driverControlled.schedule();

        Gamepads.gamepad1().leftBumper()
                .whenBecomesTrue(() -> driverControlled.setScalar(DriveConstants.slowdrivepower))
                .whenBecomesFalse(() -> driverControlled.setScalar(1));

        Gamepads.gamepad1().leftTrigger().greaterThan(0.2)
                .whenBecomesTrue(() -> Intake.mode = Intake.IntakeMode.ON)
                .whenBecomesFalse(() -> Intake.mode = Intake.IntakeMode.OFF);

        Gamepads.gamepad1().rightTrigger().greaterThan(0.2)
                .whenBecomesTrue(() -> Intake.mode = Intake.IntakeMode.REVERSE)
                .whenBecomesFalse(() -> Intake.mode = Intake.IntakeMode.OFF);


    }

    @Override
    public void onUpdate() {
        BindingManager.update();
    }

    @Override
    public void onStop() {
        BindingManager.reset();
    }
}