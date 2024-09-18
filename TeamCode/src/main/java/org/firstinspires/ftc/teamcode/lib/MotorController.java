package org.firstinspires.ftc.teamcode.lib;

import com.qualcomm.robotcore.hardware.DcMotor;


public class MotorController {

    private static DcMotor LeftBackMotor;
    private static DcMotor LeftFrontMotor;
    private static DcMotor RightBackMotor;
    private static DcMotor RightFrontMotor;

    //variables for drivebase strafe test
    static boolean PowerToggled;
    static double PowerBase = 1;
    static double PowerBaseTurn = 0.58;
    static double PowerBaseStrafe = 1.05;

    public static void initmotors (DcMotor leftBackDrive, DcMotor leftFrontDrive, DcMotor rightBackDrive, DcMotor rightFrontDrive) {
        LeftBackMotor = leftBackDrive;
        LeftFrontMotor = leftFrontDrive;
        RightBackMotor = rightBackDrive;
        RightFrontMotor = rightFrontDrive;

        LeftBackMotor.setDirection(DcMotor.Direction.REVERSE);
        LeftFrontMotor.setDirection(DcMotor.Direction.FORWARD);
        RightBackMotor.setDirection(DcMotor.Direction.REVERSE);
        RightFrontMotor.setDirection(DcMotor.Direction.FORWARD);

        LeftBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightFrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightBackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public static void runmotor(double LeftY, double LeftX, double RightX, boolean toggle){
        double denominator = Math.max(Math.abs(LeftY) + Math.abs(LeftX) + Math.abs(RightX), 1);
        double frontLeftPower = (LeftY*PowerBase - LeftX*PowerBaseStrafe + RightX*PowerBaseTurn) / denominator;
        double backLeftPower = (LeftY*PowerBase + LeftX*PowerBaseStrafe + RightX*PowerBaseTurn) / denominator;
        double frontRightPower = (LeftY*PowerBase + LeftX*PowerBaseStrafe - RightX*PowerBaseTurn) / denominator;
        double backRightPower = (LeftY*PowerBase - LeftX*PowerBaseStrafe - RightX*PowerBaseTurn) / denominator;

        LeftFrontMotor.setPower(frontLeftPower);
        LeftBackMotor.setPower(backLeftPower);
        RightFrontMotor.setPower(frontRightPower);
        RightBackMotor.setPower(backRightPower);

        if (toggle) {
            if (!PowerToggled) {
                if (PowerBase == 1) {
                    PowerBase = 0.33;
                    PowerBaseTurn = 0.3;
                    PowerBaseStrafe = 0.36;
                } else {
                    //edit these values to change drivecode
                    PowerBase = 1;
                    PowerBaseTurn = 0.8;
                    PowerBaseStrafe = 1.05;
                }
                PowerToggled = true;
            }
        }
        else {
            PowerToggled = false;
        }

    }

}
