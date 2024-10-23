package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.UtilityOctoQuadConfigMenu;

@TeleOp
public class MaxVelocityTest extends LinearOpMode{
        DcMotorEx motor;
        double currentVelocity;
        double maxVelocity = 0.0;


        @Override
        public void runOpMode() {

            if(gamepad1.dpad_up) {
                motor = hardwareMap.get(DcMotorEx.class, "LeftBackMotor");
            }else if (gamepad1.dpad_down) {
                motor = hardwareMap.get(DcMotorEx.class, "LeftBackMotor");
            }else if (gamepad1.dpad_left){
                motor = hardwareMap.get(DcMotorEx.class, "RightFrontMotor");
            }else if (gamepad1.dpad_right) {
                motor = hardwareMap.get(DcMotorEx.class, "RightBackMotor");
            }

            telemetry.addLine("Selected Motor:" + motor.toString());

            waitForStart();

            while (opModeIsActive()) {
                telemetry.addLine("Testing Motor:" + motor.toString());
                currentVelocity = motor.getVelocity();

                if (currentVelocity > maxVelocity) {
                    maxVelocity = currentVelocity;
                }

                telemetry.addData("current velocity", currentVelocity);
                telemetry.addData("maximum reached velocity", maxVelocity);
                telemetry.update();
            }
        }

    }
