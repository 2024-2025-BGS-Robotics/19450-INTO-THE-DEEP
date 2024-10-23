package org.firstinspires.ftc.teamcode.src;


import static org.firstinspires.ftc.teamcode.lib.PixyController.sign1;
import static org.firstinspires.ftc.teamcode.lib.PixyController.sign2;

import com.qualcomm.hardware.rev.RevBlinkinLedDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.LEDController;
import org.firstinspires.ftc.teamcode.lib.MotorController;
import org.firstinspires.ftc.teamcode.lib.PixyController;
import org.firstinspires.ftc.teamcode.lib.RumbleController;
import org.firstinspires.ftc.teamcode.lib.ServoController;
import org.firstinspires.ftc.teamcode.lib.SliderController;

import java.util.HashMap;
import java.util.Objects;

@TeleOp (name="LDB Main Debug", group="LinearOpmode")
public class MainDebug extends LinearOpMode {

    public ElapsedTime runtime = new ElapsedTime();
    private static String trajectoryname;



    public void runOpMode() {

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        LEDController.initlights(hardwareMap.get(RevBlinkinLedDriver.class, "blinkin"));

        PixyController pixyController = new PixyController();

        pixyController.initpixy(hardwareMap.i2cDeviceSynch.get("pixy"));
        pixyController.runpixy();

        MotorController.initmotors(
                hardwareMap.get(DcMotor.class,"LeftBackDrive"),
                hardwareMap.get(DcMotor.class,"LeftFrontDrive"),
                hardwareMap.get(DcMotor.class,"RightBackDrive"),
                hardwareMap.get(DcMotor.class,"RightFrontDrive")
        );

        HashMap<String, Servo> servos = new HashMap<>();
        HashMap<String, DcMotor> slidermotor = new HashMap<>();
        for (HardwareDevice hardwareDevice : hardwareMap) {
            if(hardwareDevice instanceof CRServo) {
                servos.put(hardwareDevice.getDeviceName(), (Servo) hardwareDevice);
            }
            if(hardwareDevice instanceof DcMotor) {
                slidermotor.put(hardwareDevice.getDeviceName(), (DcMotor) hardwareDevice);
            }

        }

        telemetry.addLine("Servos" + servos.keySet());
        telemetry.addLine("SliderMotor" + slidermotor.keySet());

        ServoController.initservo(servos);

        SliderController.initmotor(slidermotor.get("SliderMotor"));

        RumbleController Rumble = new RumbleController();
        Rumble.constructrumble();


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
                gamepad1.runRumbleEffect(RumbleController.rumbleEffect1);
                LEDController.light.setPattern(LEDController.robottesting);

            }else if (gamepad1.dpad_up && gamepad1.b){
                trajectoryname = "BlueRight";
                gamepad1.runRumbleEffect(RumbleController.rumbleEffect1);
                LEDController.light.setPattern(LEDController.robottesting);

            }else if (gamepad1.dpad_up && gamepad1.x) {
                trajectoryname = "RedLeft";
                gamepad1.runRumbleEffect(RumbleController.rumbleEffect1);
                LEDController.light.setPattern(LEDController.robottesting);

            }else if (gamepad1.dpad_up&& gamepad1.y){
                trajectoryname = "RedRight";
                gamepad1.runRumbleEffect(RumbleController.rumbleEffect1);


            }

            telemetry.addLine("Chosen Trajectory:" + trajectoryname);
            telemetry.addLine("----Press 'x' to run this trajectory----");

            if(gamepad1.x && Objects.equals(trajectoryname, "BlueLeft")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.BlueLeftSideRunner);
                LEDController.light.setPattern(LEDController.robottesting);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);

            } else if(gamepad1.x && Objects.equals(trajectoryname,"BlueRight")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.BlueRightSideRunner);
                LEDController.light.setPattern(LEDController.robottesting);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);

            }else if(gamepad1.x && Objects.equals(trajectoryname,"RedLeft")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.RedLeftSideRunner);
                LEDController.light.setPattern(LEDController.robottesting);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);

            }else if(gamepad1.x && Objects.equals(trajectoryname, "RedRight")){
                roadrunnerhandeler.drive.followTrajectorySequence(RoadRunnerHandler.RedRightSideRunner);
                telemetry.addLine("Running Trajectory:"+ trajectoryname);
                LEDController.light.setPattern(LEDController.robottesting);
            }



            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addLine("SliderPID Error:" + SliderController.PIDError);




            telemetry.addData("X value of sign1", 0xff&sign1[1]);
            telemetry.addData("X value of sign2", 0xff&sign2[1]);
            telemetry.update();





        }
    }





}
