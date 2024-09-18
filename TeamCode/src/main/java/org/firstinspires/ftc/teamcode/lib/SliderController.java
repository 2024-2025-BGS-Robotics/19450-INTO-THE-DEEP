package org.firstinspires.ftc.teamcode.lib;

import com.arcrobotics.ftclib.controller.PIDController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;




public class SliderController {
    private static DcMotor slidermotor;
    public static PIDController sliderPID = new PIDController(0, 0, 0); // Tune this for cm values

//THESE VALUES ARE IN CM
    public static final double highbasket = 109.2;
    public static final double lowbasket = 65.4;
    public static final double ground = 0;

    public static double PIDError =0;


    public static void initmotor(DcMotor motor) {
        slidermotor = motor;
        slidermotor.setDirection(DcMotorSimple.Direction.FORWARD);
        slidermotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public static void runslider(float runbuttonup, float runbuttondown) {
        if (runbuttonup <= 0.5) {
            slidermotor.setPower(0.3);
        } else if (runbuttondown <= 0.5) {
            slidermotor.setPower(-0.3);
        } else {
            slidermotor.setPower(0);
        }
    }

    public static void updateslide() {
    double output = sliderPID.calculate(
            slidermotor.getCurrentPosition()
    );
    slidermotor.setPower(output);
    PIDError = sliderPID.getPositionError();
        }

    public static void settarget(double pos){
        sliderPID.setSetPoint(pos);
    }
    public static void settarget(double pos, boolean toggle){
        if(toggle){
            sliderPID.setSetPoint(pos);
        }
    }

    public static void resetencoder(){
        slidermotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slidermotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }
}
