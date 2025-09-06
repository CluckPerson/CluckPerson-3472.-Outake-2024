package frc.robot.Outake;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class OutConstants {

    /*set motor id's
    Gains (for the PID's)
    and positions?
    */
    static double WristTolerance = 0.2;
    static int Wheel1_ID = 1;
    static int Wheel2_ID = 2;
    static int Wrist_ID = 3;
    static double WristAmp = 25; //Amp Limit for wrist. Idk the actual vale
    static double WheelsAmp = 25; //Amp Limit for wrist

    public SparkMax CANWrist = new SparkMax(3, MotorType.kBrushless);
}
