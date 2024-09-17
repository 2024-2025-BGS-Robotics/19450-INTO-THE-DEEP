package org.firstinspires.ftc.teamcode.src;



import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.RoadRunner_drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunner_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.lib.SliderController;

public class RoadRunnerHandler extends LinearOpMode {

    public static TrajectorySequence BlueRightSideRunner;
    public static TrajectorySequence BlueLeftSideRunner;
    public static TrajectorySequence RedRightSideRunner;
    public static  TrajectorySequence RedLeftSideRunner;
    SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

    @Override
    public void runOpMode() {


        TrajectorySequence BlueRightSide = drive.trajectorySequenceBuilder(new Pose2d(12, 63, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(0, 33, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    SliderController.sliderPID.setSetPoint(SliderController.highbasket);
                    SliderController.updateslide();
                    //DROP SPECIMEN
                    SliderController.sliderPID.setSetPoint(SliderController.ground);
                    SliderController.updateslide();
                })
                .back(4)

                .lineToLinearHeading(new Pose2d(48, 37, Math.toRadians(270)))

                //Pick up Sample

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                .addDisplacementMarker(() -> {
                    SliderController.sliderPID.setSetPoint(SliderController.highbasket);
                    SliderController.updateslide();
                    //drop sample
                    SliderController.sliderPID.setSetPoint(SliderController.ground);
                    SliderController.updateslide();
                })
                .lineToLinearHeading(new Pose2d(58, 37, Math.toRadians(270)))

                //Pick up Sample

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                .addDisplacementMarker(() -> {
                    SliderController.sliderPID.setSetPoint(SliderController.highbasket);
                    SliderController.updateslide();
                    //drop sample
                    SliderController.sliderPID.setSetPoint(SliderController.ground);
                    SliderController.updateslide();
                })

                .lineToLinearHeading(new Pose2d(58, 27, Math.toRadians(0)))
                //Pick up Sample

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                .addDisplacementMarker(() -> {
                    SliderController.sliderPID.setSetPoint(SliderController.highbasket);
                    SliderController.updateslide();
                    //drop sample
                    SliderController.sliderPID.setSetPoint(SliderController.ground);
                    SliderController.updateslide();
                })
                .build();

        TrajectorySequence BlueLeftSide = drive.trajectorySequenceBuilder(new Pose2d(-12, 63, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(-48, 37, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(-58, 37, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(-58, 27, Math.toRadians(180)))

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(-62,63, Math.toRadians(-270)))

                .build();

        TrajectorySequence RedLeftSide = drive.trajectorySequenceBuilder(new Pose2d(-12, -63, Math.toRadians(-270)))
            .lineToLinearHeading(new Pose2d(0, -33, Math.toRadians(-270)))

            .waitSeconds(2)
            .back(4)

            .lineToLinearHeading(new Pose2d(-48, -37, Math.toRadians(-270)))

            .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))

            .lineToLinearHeading(new Pose2d(-58, -37, Math.toRadians(-270)))

            .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))

            .lineToLinearHeading(new Pose2d(-58, -27, Math.toRadians(180)))
                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))

                .lineToLinearHeading(new Pose2d(62,-63, Math.toRadians(270)))

                .build();

        TrajectorySequence RedRightSide = drive.trajectorySequenceBuilder(new Pose2d(12, -63, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(48, -37, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(58, -37, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(58, -27, Math.toRadians(0)))

                .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))

                .build();

    BlueLeftSideRunner = BlueLeftSide;
    BlueRightSideRunner = BlueRightSide;
    RedRightSideRunner = RedRightSide;
    RedLeftSideRunner = RedLeftSide;

    }


}
