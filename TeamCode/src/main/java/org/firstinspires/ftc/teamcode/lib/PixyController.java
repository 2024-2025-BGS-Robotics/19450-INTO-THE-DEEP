package org.firstinspires.ftc.teamcode.lib;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;



/*
Bytes    16-bit word    Description
        ----------------------------------------------------------------
        0, 1     y              sync: 0xaa55=normal object, 0xaa56=color code object
        2, 3     y              checksum (sum of all 16-bit words 2-6, that is, bytes 4-13)
        4, 5     y              signature number
        6, 7     y              x center of object
        8, 9     y              y center of object
        10, 11   y              width of object
        12, 13   y              height of object
        */
public class PixyController {
    public static I2cDeviceSynch pixy;

    public static byte[] sign1;
    public static byte[] sign2;



    //our Pixy device

    public void initpixy (I2cDeviceSynch Pixy) {
        //setting up Pixy to the hardware map
        pixy = Pixy;

        //setting Pixy's I2C Address
        pixy.setI2cAddress(I2cAddr.create7bit(0x54));

        //setting Pixy's read window. You'll want these exact parameters, and you can reference the
        // SDK Documentation to learn more
        I2cDeviceSynch.ReadWindow readWindow = new I2cDeviceSynch.ReadWindow(1, 26,
                I2cDeviceSynch.ReadMode.REPEAT);
        pixy.setReadWindow(readWindow);

        //required to "turn on" the device
        pixy.engage();

    }
        public void runpixy (){
            sign1 = pixy.read(0x51,5);
            sign2 = pixy.read(0x52,5);

        }

}
