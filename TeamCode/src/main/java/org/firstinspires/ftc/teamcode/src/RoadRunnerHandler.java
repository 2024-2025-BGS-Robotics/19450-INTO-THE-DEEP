package org.firstinspires.ftc.teamcode.src;



import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;


import org.firstinspires.ftc.teamcode.RoadRunner_drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunner_trajectorysequence.TrajectorySequence;
import org.firstinspires.ftc.teamcode.lib.SliderController;

public class  RoadRunnerHandler {

    public static TrajectorySequence BlueRightSideRunner;
    public static TrajectorySequence BlueLeftSideRunner;
    public static TrajectorySequence RedRightSideRunner;
    public static  TrajectorySequence RedLeftSideRunner;
    SampleMecanumDrive drive;

    public void constructPaths(HardwareMap hardwareMap) {

        drive = new SampleMecanumDrive(hardwareMap);

        TrajectorySequence BlueRightSide = drive.trajectorySequenceBuilder(new Pose2d(12, 63, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(0, 33, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //DROP SPECIMEN
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })

                .back(4)

                .lineToLinearHeading(new Pose2d(48, 37, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //drop sample
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })
                .lineToLinearHeading(new Pose2d(58, 37, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })


                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //drop sample
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })

                .lineToLinearHeading(new Pose2d(58, 27, Math.toRadians(0)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //drop sample
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })
                .build();

        TrajectorySequence BlueLeftSide = drive.trajectorySequenceBuilder(new Pose2d(-12, 63, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(-48, 37, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    //Drop Sample
                })

                .lineToLinearHeading(new Pose2d(-58, 37, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    //Drop Sample
                })

                .lineToLinearHeading(new Pose2d(-58, 27, Math.toRadians(180)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })
                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    //Drop Sample
                })

                .lineToLinearHeading(new Pose2d(-62,63, Math.toRadians(-270)))//Park in Observation Zone

                .build();


        TrajectorySequence RedLeftSide = drive.trajectorySequenceBuilder(new Pose2d(-12, -63, Math.toRadians(-270)))
                .lineToLinearHeading(new Pose2d(0, -33, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //DROP SPECIMEN
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })

                .waitSeconds(2)
                .back(4)

                .lineToLinearHeading(new Pose2d(-48, -37, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //DROP SPECIMEN
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })

                .lineToLinearHeading(new Pose2d(-58, -37, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //DROP SPECIMEN
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })

                .lineToLinearHeading(new Pose2d(-58, -27, Math.toRadians(180)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))
                .addDisplacementMarker(() -> {
                    SliderController.settarget(SliderController.HIGH_BASKET);
                    SliderController.updateslide();
                    //DROP SPECIMEN
                    SliderController.settarget(SliderController.GROUND);
                    SliderController.updateslide();
                })


                .build();
        TrajectorySequence RedRightSide = drive.trajectorySequenceBuilder(new Pose2d(12, -63, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(48, -37, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    //Drop Sample
                })

                .lineToLinearHeading(new Pose2d(58, -37, Math.toRadians(-270)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    //Drop Sample
                })

                .lineToLinearHeading(new Pose2d(58, -27, Math.toRadians(0)))
                .addDisplacementMarker(() -> {
                    //Pickup Sample
                })

                .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))
                .addDisplacementMarker(() -> {
                    //Drop Sample
                })

                .lineToLinearHeading(new Pose2d(62,-63, Math.toRadians(270)))//Park in Observation Zone

                .build();

    BlueLeftSideRunner = BlueLeftSide;
    BlueRightSideRunner = BlueRightSide;
    RedRightSideRunner = RedRightSide;
    RedLeftSideRunner = RedLeftSide;

    }


}
