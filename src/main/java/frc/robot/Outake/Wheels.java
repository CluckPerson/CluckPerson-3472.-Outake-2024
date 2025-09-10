package frc.robot.Outake;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import lib.Forge.REV.SparkMax.ForgeSparkMax;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.hardware.core.CoreTalonFX;
import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.NeutralOut;
import com.ctre.phoenix6.controls.VelocityTorqueCurrentFOC;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.sim.TalonFXSimState;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Wheels extends SubsystemBase {
    /*      TODO:
      Add JM's code. After this, we can make the constants
    */    
    ForgeSparkMax Wheel1;
    ForgeSparkMax Wheel2;
    
    private TalonFX TalonWrist;
    private TalonFXConfiguration wheelMotor1Config;//TODO CONFIG

 public Wheels() {
   ForgeSparkMax Wheel1 = new ForgeSparkMax(OutConstants.Wheel1_ID, MotorType.kBrushless);
   ForgeSparkMax Wheel2 = new ForgeSparkMax(OutConstants.Wheel2_ID, MotorType.kBrushless);
   TalonFX TalonWrist = new TalonFX(OutConstants.KrakenWheel_ID);

 
// final TalonFXSimState wheelMotor1_Sim = TalonWrist.getSimState();

 final DutyCycleOut m_talonFXOut = new DutyCycleOut(0);
 TalonWrist.optimizeBusUtilization()
 final TalonFXConfiguration m_talonFXConfig = new TalonFXConfiguration();
// final CANcoderConfiguration m_cancoderConfig = new CANcoderConfiguration();
 TalonWrist.getConfigurator().apply(m_talonFXConfig);
 
 }


 
  public void runWheels(double speed) {
   // Implementation for running wheels
   TalonWrist.setControl(new VelocityVoltage(speed));
   Wheel1.set(speed);
   Wheel2.set(speed);
  }


  public void stopWheels() {
   // Implementation for stopping wheels
   TalonWrist.setControl(new NeutralOut());
   Wheel1.stopMotor();
   Wheel2.stopMotor();
 }
}