package org.firstinspires.ftc.teamcode.lib;

import android.util.Pair;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.HashMap;

public class ServoController {


    public static void initservo(HashMap<String, Servo> servohash){
        servohash.get("Servo1").setDirection(Servo.Direction.FORWARD);
    }

    public static void runservos()
}
