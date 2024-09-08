package org.firstinspires.ftc.teamcode.src;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name="Finite State Machine", group="Opmode")
public class FiniteStateMachine {
    private enum State{
        INTAKE,
        TRANSFER,
        OUTTAKE,
        LOW,
        HIGH,
    };

    State autostate = State.INTAKE;

    public void runstatemachine(){

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
