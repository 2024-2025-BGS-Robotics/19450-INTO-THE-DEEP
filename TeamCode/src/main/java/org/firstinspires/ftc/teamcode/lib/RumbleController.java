package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.Gamepad;


public class RumbleController {
    public static Gamepad.RumbleEffect rumbleEffect1;
    public static Gamepad.RumbleEffect rumbleEffect2;

    public void constructrumble() {
        Gamepad.RumbleEffect effect1 = new Gamepad.RumbleEffect.Builder()
                .addStep(0.0, 1.0, 500)
                .addStep(0.0, 0.0, 300)
                .addStep(1.0, 0.0, 250)
                .addStep(0.0, 0.0, 250)
                .addStep(1.0, 1.0, 250)
                .build();


        Gamepad.RumbleEffect effect2 = new Gamepad.RumbleEffect.Builder()
                .addStep(0.5,0.5,500)
                .addStep(0,0.5,300)
                .addStep(0.5,0,300)
                .build();

        rumbleEffect1 = effect1;
        rumbleEffect2 = effect2;

    }


}
