package frc.robot.Outake;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import frc.robot.Outake.OutConstants;
import frc.robot.Outake.Wheels;

import lib.Forge.REV.SparkMax.ForgeSparkMax;
import lib.Forge.Math.Controllers.Control;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.math.controller.PIDController;

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
