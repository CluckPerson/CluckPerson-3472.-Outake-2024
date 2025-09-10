package frc.robot.Outake;
/*
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
*/
import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VelocityTorqueCurrentFOC;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.sim.TalonFXSimState;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import lib.Forge.Math.Constants.ProfileGains.CompleteFeedForwardGains;
import lib.Forge.Math.Constants.ProfileGains.PIDGains;
import lib.Forge.Math.Constants.ProfileGains.SimpleFeedForwardGains;

import com.revrobotics.spark.SparkMax;

public class OutConstants {
    final static double WristTolerance = 0.2;

    final static int Wheel1_ID = 1;
    final static int Wheel2_ID = 2;
    
    final static int KrakenWheel_ID = 1;

    final static int CANWrist_ID = 3;
    final static int KrakenWrist_ID = 1;
    
    final static double WristAmp = 25; //Amp Limit for wrist. Idk the actual vale
    final static double WheelsAmp = 25; //Amp Limit for wrist

    // PID pal wrist 
    public static final double Wrist_kP = 0.1;
    public static final double Wrist_kI = 0.0;
    public static final double Wrist_kD = 0.0;
    public static final double Wrist_IZone = 0.0;
    public static final double Wrist_MaxOutput = 1.0;
    public static final double Wrist_MinOutput = -1.0;
/*/
    public OutConstants(){
    /*set motor id's
    Gains (for the PID's)
    and positions?


    VelocityVoltage m_request = new VelocityVoltage(0).withSlot(0);
    TalonFXConfiguration KrakenConfigs = new TalonFXConfiguration();
    TalonFXConfiguration angMotor1Config = new TalonFXConfiguration();

}
*/
}