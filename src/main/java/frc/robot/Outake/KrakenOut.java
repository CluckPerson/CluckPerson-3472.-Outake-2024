package frc.robot.Outake;

import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.hardware.TalonFX;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.configs.Slot0Configs;




public class KrakenOut extends SubsystemBase {



 private TalonFX KrakenWrist;
 private MotionMagicVoltage angControl;

 private MotionMagicVoltage motionMagicControl;
 private TalonFXConfiguration motionMagicConfig;

   public KrakenOut() {
    MotionMagicVoltage angControl = new MotionMagicVoltage(0.0); 
    KrakenWrist = new TalonFX(OutConstants.KrakenWrist_ID);
     motionMagicConfig = new TalonFXConfiguration();

     configureMotionMagic();
     applyMotionMagicConfig();

       TalonFXConfiguration KrakenWristConfig = new TalonFXConfiguration();
       VelocityVoltage m_request = new VelocityVoltage(0).withSlot(0);


       Slot0Configs slot0 = new Slot0Configs();
       //Array []?
       slot0.kP = 4.8; // A position error of 2.5 rotations results in 12 V output
       slot0.kI = 0.0; // no output for integrated error
       slot0.kD = 0.01; // A velocity error of 1 rps results in 0.1 V output
       slot0.kS = 0.25; // Add 0.25 V output to overcome static friction
       slot0.kV = 0; // A velocity target of 1 rps results in 0.12 V output
       slot0.kA = 0; // An acceleration of 1 rps/s requires 0.01 V output
       slot0.kG = 0; // A position error of 2.5 rotations results in 12 V output
       motionMagicConfig.MotionMagic.MotionMagicAcceleration = OutConstants.MMAcceleration; 
       motionMagicConfig.MotionMagic.MotionMagicCruiseVelocity = OutConstants.MMCruiseVelocity;
      KrakenWrist.getConfigurator().apply(slot0);
      KrakenWrist.setControl(m_request.withVelocity(8));
     
   }

   private void configureMotionMagic() {
   //Maldito perfil trapexoidal, por eso CEM esta en decadencia -Chong
       motionMagicConfig.MotionMagic.MotionMagicAcceleration = 5000; 
       motionMagicConfig.MotionMagic.MotionMagicCruiseVelocity = 10000; 
       motionMagicConfig.Slot0.kP = 0.5; 
       motionMagicConfig.Slot0.kI = 0.0; 
       motionMagicConfig.Slot0.kD = 0.0; 
       motionMagicConfig.Slot0.kV = 0.2; 
   }

   private void applyMotionMagicConfig() {
       KrakenWrist.getConfigurator().apply(motionMagicConfig);
       motionMagicControl = new MotionMagicVoltage(0.0)
           .withSlot(0)
           .withPosition(0.0)
           .withFeedForward(0.0);
   }

   public void setMotionMagicPosition(double position) {
       KrakenWrist.setControl(motionMagicControl.withPosition(position));
   }

   public double getCurrentPosition() {
       return KrakenWrist.getPosition().getValueAsDouble();
   }

   public boolean isAtTarget(double targetPosition, double tolerance) {
       double currentPosition = getCurrentPosition();
       return Math.abs(currentPosition - targetPosition) <= tolerance;
   }

  public void useAngMotor() {
   KrakenWrist.setControl(angControl);//
 }



  public void setPosition(double rotations) {
    KrakenWrist.setControl(angControl.withPosition(rotations));
  }
  public double getPosition() {
    return KrakenWrist.getPosition().getValueAsDouble();
}
 public void setVelocity(double velocity) {  
  KrakenWrist.setControl(new VelocityVoltage(velocity).withSlot(0).withFeedForward(0.5));
    
  }
public double getVelocity() {
    return KrakenWrist.getVelocity().getValueAsDouble(); // Get current velocity in rotations/sec
}

  public Command setAngPositionCommand(double position) {
    return this.runOnce(() -> setPosition(position)).withName("SetAngPosition"); 
    /*
    esteeeem lo de hasta abajo es por si hacimos simulacion con eso
    que no creo
    por eso no lo temine 
    Atte: JM
    */
  }
}
