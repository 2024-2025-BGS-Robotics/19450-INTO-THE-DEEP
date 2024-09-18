package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Disabled
@TeleOp (name="Finite State Machine", group="LinearOpmode")
public class FiniteStateMachine {
    private enum State{
        INTAKE,
        TRANSFER,
        OUTTAKE,
        LOW,
        HIGH,
    };

    static State autostate = State.INTAKE;

    public static void runstatemachine(){

        switch(autostate){
            case INTAKE:
                //do something

                break;

            case TRANSFER:
                //do something

                break;


            case OUTTAKE:



                break;

            case LOW:



                break;

            case HIGH:


                break;
        }



    }











}
