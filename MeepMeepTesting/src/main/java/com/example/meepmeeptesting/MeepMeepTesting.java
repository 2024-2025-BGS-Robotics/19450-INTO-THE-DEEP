package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeBlueDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedDark;
import com.noahbres.meepmeep.core.colorscheme.scheme.ColorSchemeRedLight;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class MeepMeepTesting {

    private static RoadRunnerBotEntity RedBot1;

    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(900);

            System.out.println("Start");


             RedBot1 = new DefaultBotBuilder(meepMeep)
                    // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                    // Set bot colour: Blue Dark, Blue Light, Red Dark, Red Light
                    .setColorScheme(new ColorSchemeRedDark())
                    .setConstraints(52, 60, Math.toRadians(180), Math.toRadians(180), 15)
                    .followTrajectorySequence(drive ->
                            drive.trajectorySequenceBuilder(new Pose2d(35, 63, Math.toRadians(270)))
                                    .splineToLinearHeading(new Pose2d(0, 33,Math.toRadians(270)), Math.toRadians(0))
                                    .waitSeconds(2)
                                    .back(4)
                                    .splineToLinearHeading(new Pose2d(48, 38,Math.toRadians(270)), Math.toRadians(5))
                                    .splineToLinearHeading(new Pose2d(56, 57,Math.toRadians(-320)), Math.toRadians(-200))
                                    .splineToLinearHeading(new Pose2d(58, 38,Math.toRadians(270)), Math.toRadians(0))
                                    .splineToLinearHeading(new Pose2d(56, 57,Math.toRadians(-320)), Math.toRadians(-20))
                                    .splineToLinearHeading(new Pose2d(58, 27,Math.toRadians(0)), Math.toRadians(-20))
                                    .splineToLinearHeading(new Pose2d(56, 57,Math.toRadians(-320)), Math.toRadians(0))
                                    .build()

                    );

             System.out.println("Finished");

        Image img = null;
        try { img = ImageIO.read(new File("MeepMeepTesting/src/resources/Into-The-Deep-Dark.png")); }
        catch (IOException e) {}

        meepMeep.setBackground(img)
                .setBackgroundAlpha(0.95f)
                .addEntity(RedBot1)
                .start();
    }
}


