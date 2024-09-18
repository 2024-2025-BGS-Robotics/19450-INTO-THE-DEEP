package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

public class ServoController {

    private static CRServo conservo;
    private static Servo servo;

    public static void initservo(CRServo CRSERVO, Servo Servo){
        conservo = CRSERVO;
        servo = Servo;

    }
}
