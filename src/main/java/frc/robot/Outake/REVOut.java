package frc.robot.Outake;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.servohub.ServoHub.ResetMode;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import frc.robot.Outake.OutConstants;
import frc.robot.Outake.Wheels;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;

public class REVOut {
          /*      
    What is? From BulukLib
    private ClosedLoopControl pid;
    private ClosedLoopRequest request;

    We should use ForgPlus
     */
    
    SparkMax CANWrist = new SparkMax(OutConstants.Wrist_ID, MotorType.kBrushless);
    SparkAbsoluteEncoder WristEnc = CANWrist.getAbsoluteEncoder();
    //RelativeEncoder JMDeity = CANWrist.getEncoder(); //Not the type we want
    SparkMaxConfig WristConfig = new SparkMaxConfig();
 //idk why this is wrong

private void Burnflash(){
        CANWrist.setCANTimeout(250);
         WristConfig.
            inverted(false).
            idleMode(IdleMode.kBrake).
            smartCurrentLimit(25);//limit in Amps
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
private void setPosition(){
    //CANWrist.set      we need the ClosedLoopControl (PID)
}
private double getWrist(){ //Request Position
    return WristEnc.getPosition() * 360;
}
private double requestSetpoint(){//Request Setpoint
    //return we need the ClosedLoopRequest
    //https://imcab.github.io/ForgeDocumentation/page9
}
private boolean atGoal(){
    return Math.abs(getWrist() - requestSetpoint()) <= OutConstants.WristTolerance; //How much tolerance we want
}
private void stopWrist(){
    CANWrist.stopMotor();
}
}