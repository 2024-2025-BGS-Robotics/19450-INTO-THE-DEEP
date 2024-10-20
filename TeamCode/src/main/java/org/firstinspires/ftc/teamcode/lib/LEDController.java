package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;

public class LEDController {
    public static RevBlinkinLedDriver light;
    public static void initlights(RevBlinkinLedDriver light1){
        light = light1;
    }

    public static final RevBlinkinLedDriver.BlinkinPattern redAlliance =
            RevBlinkinLedDriver.BlinkinPattern.BREATH_RED;


    public static final RevBlinkinLedDriver.BlinkinPattern blueAlliance =
            RevBlinkinLedDriver.BlinkinPattern.BREATH_BLUE;

    public static final RevBlinkinLedDriver.BlinkinPattern inIntake =
            RevBlinkinLedDriver.BlinkinPattern.RAINBOW_FOREST_PALETTE;

    public static final RevBlinkinLedDriver.BlinkinPattern pickingUp =
            RevBlinkinLedDriver.BlinkinPattern.FIRE_LARGE;

    public static final RevBlinkinLedDriver.BlinkinPattern inAuto =
            RevBlinkinLedDriver.BlinkinPattern.STROBE_GOLD;


    public static final RevBlinkinLedDriver.BlinkinPattern robottesting=
            RevBlinkinLedDriver.BlinkinPattern.CONFETTI;

}
