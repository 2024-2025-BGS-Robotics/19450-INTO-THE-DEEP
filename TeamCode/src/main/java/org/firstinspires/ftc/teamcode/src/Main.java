package org.firstinspires.ftc.teamcode.src;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.MotorController;
import org.firstinspires.ftc.teamcode.lib.SliderController;


@TeleOp (name="LDB Main", group="LinearOpmode")
public class Main extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        MotorController.initmotors(
                hardwareMap.get(DcMotor.class,"LeftBackDrive"),
                hardwareMap.get(DcMotor.class,"LeftFrontDrive"),
                hardwareMap.get(DcMotor.class,"RightBackDrive"),
                hardwareMap.get(DcMotor.class,"RightFrontDrive")
        );

        RoadRunnerHandler roadrunnerhandeler = new RoadRunnerHandler();

        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            MotorController.runmotor(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.right_bumper);
            roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.BlueLeftSideRunner);


            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addLine("SliderPID Error:" + SliderController.PIDError);

            telemetry.update();
        }
    }





}
