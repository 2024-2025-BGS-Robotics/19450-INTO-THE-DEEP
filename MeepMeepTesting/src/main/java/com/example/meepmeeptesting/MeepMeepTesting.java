package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueLight;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MeepMeepTesting {

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(900);

            System.out.println("Init");
        // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
        // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
        RoadRunnerBotEntity rightSideBlueBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                .setColorScheme(new ColorSchemeBlueLight())
                .setConstraints(52, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(12, 63, Math.toRadians(270)))
                                .lineToLinearHeading(new Pose2d(0, 33, Math.toRadians(270)))
                                .waitSeconds(2)
                                .back(4)
                                .lineToLinearHeading(new Pose2d(48, 38, Math.toRadians(270)))
                                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                                .lineToLinearHeading(new Pose2d(58, 38, Math.toRadians(270)))
                                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                                .lineToLinearHeading(new Pose2d(58, 27, Math.toRadians(0)))
                                .lineToLinearHeading(new Pose2d(56, 57, Math.toRadians(-320)))
                                .build()

                );

        //                                                     .splineToLinearHeading(new Pose2d(-54, 27,Math.toRadians(180)), Math.toRadians(0))
        //                                                     .waitSeconds(1)
        RoadRunnerBotEntity leftSideBlueBot = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeBlueDark())
                .setConstraints(52, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(-12, 63, Math.toRadians(270)))
                                        .lineToLinearHeading(new Pose2d(-48, 38, Math.toRadians(270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(-58, 38, Math.toRadians(270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(-58, 27, Math.toRadians(180)))
                                        .waitSeconds(1)
//                                                     .splineToLinearHeading(new Pose2d(-54, 27,Math.toRadians(180)), Math.toRadians(0))
//                                                     .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(-48, 58, Math.toRadians(-270)))
                                        .waitSeconds(1)
                                        .build()
                );

        RoadRunnerBotEntity rightSideRedBot = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedDark())
                .setConstraints(52, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-12, -63, Math.toRadians(-270)))
                                .lineToLinearHeading(new Pose2d(0, -33, Math.toRadians(-270)))
                                .waitSeconds(2)
                                .back(4)
                                .lineToLinearHeading(new Pose2d(-48, -38, Math.toRadians(-270)))
                                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))
                                .lineToLinearHeading(new Pose2d(-58, -38, Math.toRadians(-270)))
                                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))
                                .lineToLinearHeading(new Pose2d(-58, -27, Math.toRadians(180)))
                                .lineToLinearHeading(new Pose2d(-56, -57, Math.toRadians(228)))
                                .build()
                );

        //                                                     .splineToLinearHeading(new Pose2d(-54, 27,Math.toRadians(180)), Math.toRadians(0))
        //                                                     .waitSeconds(1)
        RoadRunnerBotEntity leftSideRedBot = new DefaultBotBuilder(meepMeep)
                .setColorScheme(new ColorSchemeRedLight())
                .setConstraints(52, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                                drive.trajectorySequenceBuilder(new Pose2d(12, -63, Math.toRadians(-270)))
                                        .lineToLinearHeading(new Pose2d(48, -38, Math.toRadians(-270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(58, -38, Math.toRadians(-270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))
                                        .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(58, -27, Math.toRadians(0)))
                                        .waitSeconds(1)
//                                                     .splineToLinearHeading(new Pose2d(-54, 27,Math.toRadians(180)), Math.toRadians(0))
//                                                     .waitSeconds(1)
                                        .lineToLinearHeading(new Pose2d(48, -58, Math.toRadians(270)))
                                        .waitSeconds(1)
                                        .build()
                );

             System.out.println("Start");

        Image img = null;
        try { img = ImageIO.read(new File("MeepMeepTesting/src/resources/Into-The-Deep-Dark.png")); }
        catch (IOException ignored) {}

        meepMeep.setBackground(img)
                .setBackgroundAlpha(0.95f)
                .addEntity(rightSideBlueBot)
                .addEntity(leftSideBlueBot)
                .addEntity(rightSideRedBot)
                .addEntity(leftSideRedBot)
                .start();


    }



}


