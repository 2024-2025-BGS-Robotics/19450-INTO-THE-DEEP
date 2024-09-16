package org.firstinspires.ftc.teamcode.src;



import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import org.firstinspires.ftc.teamcode.RoadRunner_drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunner_trajectorysequence.TrajectorySequence;

public class RoadRunnerHandler extends LinearOpMode {
    SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

    public TrajectorySequence BlueRightSideRunner;
    public TrajectorySequence BlueLeftSideRunner;
    public TrajectorySequence RedRightSideRunner;
    public TrajectorySequence RedLeftSideRunner;

    @Override
    public void runOpMode() {
        TrajectorySequence BlueRightSide = drive.trajectorySequenceBuilder(new Pose2d(12, 63, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(0, 33, Math.toRadians(270)))

                .waitSeconds(2)
                .back(4)

                .lineToLinearHeading(new Pose2d(48, 38, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))

                .lineToLinearHeading(new Pose2d(58, 38, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))

                .lineToLinearHeading(new Pose2d(58, 27, Math.toRadians(0)))

                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))

                .build();

        TrajectorySequence BlueLeftSide = drive.trajectorySequenceBuilder(new Pose2d(-12, 63, Math.toRadians(270)))
                .lineToLinearHeading(new Pose2d(-48, 38, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(-58, 38, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(-58, 27, Math.toRadians(180)))

                .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))

                .build();

        TrajectorySequence RedRightSide = drive.trajectorySequenceBuilder(new Pose2d(-12, -63, Math.toRadians(-270)))
            .lineToLinearHeading(new Pose2d(0, -33, Math.toRadians(-270)))

            .waitSeconds(2)
            .back(4)

            .lineToLinearHeading(new Pose2d(-48, -38, Math.toRadians(-270)))

            .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))

            .lineToLinearHeading(new Pose2d(-58, -38, Math.toRadians(-270)))

            .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))

            .lineToLinearHeading(new Pose2d(-58, -27, Math.toRadians(180)))
                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))

            .build();

        TrajectorySequence RedLeftSide = drive.trajectorySequenceBuilder(new Pose2d(12, -63, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(48, -38, Math.toRadians(-270)))

                .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))

                .lineToLinearHeading(new Pose2d(58, -38, Math.toRadians(-270)))

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
