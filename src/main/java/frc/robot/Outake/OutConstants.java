package frc.robot.Outake;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import lib.Forge.Math.Constants.ProfileGains.CompleteFeedForwardGains;
import lib.Forge.Math.Constants.ProfileGains.PIDGains;
import lib.Forge.Math.Constants.ProfileGains.SimpleFeedForwardGains;

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

    SimpleFeedForwardGains WristFFS = new SimpleFeedForwardGains(0, 0, 0);
    CompleteFeedForwardGains WristFFC = new CompleteFeedForwardGains(0, 0, 0, 0);

    static TalonFXConfiguration KrakenConfigs = new TalonFXConfiguration();
    static Slot0Configs slot0 = KrakenConfigs.Slot0; //I might be missing some configs, but idk how to edit them

    public SparkMax CANWrist = new SparkMax(3, MotorType.kBrushless);
}
