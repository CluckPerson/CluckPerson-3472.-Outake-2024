package frc.robot.Outake;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Outake.OutConstants;
import frc.robot.Outake.Wheels;
// Ensure this is the correct package for VelocityGoal

import lib.Forge.REV.SparkMax.ForgeSparkMax;
import lib.Forge.Math.Controllers.Control;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.units.measure.Velocity;


public class REVOut extends SubsystemBase{
    private ForgeSparkMax CANWrist;   
    private SparkAbsoluteEncoder WristEnc;
    private SparkMaxConfig WristConfig;
    private PIDController wristPID;
    
//  private RelativeEncoder WristEnc;
        
    /*      
    What is? From BulukLib


    We should use ForgPlus
     */

public REVOut(){
        CANWrist = new ForgeSparkMax(OutConstants.CANWrist_ID);
        WristEnc = CANWrist.getAbsoluteEncoder();
        wristPID = new PIDController(OutConstants.Wrist_kP, OutConstants.Wrist_kI, OutConstants.Wrist_kD);
        wristPID.setTolerance(OutConstants.WristTolerance);
        Burnflash();
    }

private void Burnflash(){
        CANWrist.setCANTimeout(250);
        CANWrist.flashConfiguration(false, IdleMode.kBrake, 25, false);// True for 12V voltage Compensation
            //positionConversionFactor is worth looking into
        CANWrist.configure(WristConfig, com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); //couldn't import for some reason
    }
/*Methods go here:
TODO:
    Set/Request Position
    Setpoint
    Boolean atGoal
    Stop
zeroOffset is worth looking into
*/
private void setPosition(double targetPosition) {
    double currentPosition = WristEnc.getPosition() * 360;
    double output = wristPID.calculate(currentPosition, targetPosition);
        output = Math.max(OutConstants.Wrist_MinOutput, Math.min(OutConstants.Wrist_MaxOutput, output));
        CANWrist.set(output);
}

/* matate stv - JM
public double FeedForwardCalculate(double kA, double kV, double kG, double kS){
    ArmFeedforward feedforward = new ArmFeedforward(kS, kV, kG, kA);
        return feedforward.calculate(1, 2, 3);
} //Esta es la ofrma en la que me marcaba wplib, no c si este bien, si si, alch que tibios somos

//La que sigue es la fumada que se sacaron en leon
/public double FeedForwardCalculate(double kA, double kV, double kG, double kS, double velocity, double acceleration, double angle){
   
    double feedforwardout = kS * Math.signum(velocity) + kV * velocity + kG + kA * acceleration;
    return feedforwardout;
}   
*/
private double getWrist(){ //Request Position
    return WristEnc.getPosition() * 360;
}

private boolean atGoal(){
    return wristPID.atSetpoint();
}

private void stopWrist(){
    CANWrist.stopMotor();
}
}