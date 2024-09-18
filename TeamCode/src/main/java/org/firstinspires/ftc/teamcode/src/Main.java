package org.firstinspires.ftc.teamcode.src;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.MotorController;
import org.firstinspires.ftc.teamcode.lib.SliderController;

import java.util.Objects;

@TeleOp (name="LDB Main", group="LinearOpmode")
public class Main extends LinearOpMode {
    public ElapsedTime runtime = new ElapsedTime();
    private static String trajectoryname;

    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        MotorController.initmotors(
                hardwareMap.get(DcMotor.class,"LeftBackDrive"),
                hardwareMap.get(DcMotor.class,"LeftFrontDrive"),
                hardwareMap.get(DcMotor.class,"RightBackDrive"),
                hardwareMap.get(DcMotor.class,"RightFrontDrive")
        );


//        SliderController.initmotor(
//                hardwareMap.get(DcMotor.class,"SliderMotor")
//        );

        RoadRunnerHandler roadrunnerhandeler = new RoadRunnerHandler();

        roadrunnerhandeler.constructPaths(hardwareMap);
        // Wait for the game to start (driver presses START)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            MotorController.runmotor(-gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, gamepad1.right_bumper);
//            SliderController.runslider(gamepad1.left_trigger, gamepad1.right_trigger);

            if(gamepad1.dpad_up && gamepad1.a) {
                trajectoryname = "BlueLeft";
            }else if (gamepad1.dpad_up && gamepad1.b){
                trajectoryname = "BlueRight";
            }else if (gamepad1.dpad_up && gamepad1.x) {
                trajectoryname = "RedLeft";
            }else if (gamepad1.dpad_up&& gamepad1.y){
                trajectoryname = "RedRight";
            }

            telemetry.addLine("Chosen Trajectory:" + trajectoryname);
            telemetry.addLine("----Press 'x' to run this trajectory----");

            if(gamepad1.x && Objects.equals(trajectoryname, "BlueLeft")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.BlueLeftSideRunner);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);
            } else if(gamepad1.x && Objects.equals(trajectoryname,"BlueRight")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.BlueRightSideRunner);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);
            }else if(gamepad1.x && Objects.equals(trajectoryname,"RedLeft")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.RedLeftSideRunner);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);
            }else if(gamepad1.x && Objects.equals(trajectoryname, "RedRight")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.RedRightSideRunner);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);
            }



            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addLine("SliderPID Error:" + SliderController.PIDError);

            telemetry.update();
        }
    }





}
