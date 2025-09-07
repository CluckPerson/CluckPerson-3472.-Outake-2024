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
import lib.Forge.REV.SparkMax.ForgeSparkMax;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class REVOut extends SubsystemBase{
    private ForgeSparkMax CANWrist;   
    private SparkAbsoluteEncoder WristEnc;
    private SparkMaxConfig WristConfig;
    
//  private RelativeEncoder WristEnc;
        
    /*      
    What is? From BulukLib


    We should use ForgPlus
     */

public REVOut(){
        ForgeSparkMax CANWrist = new ForgeSparkMax(OutConstants.Wrist_ID);
        SparkAbsoluteEncoder WristEnc = CANWrist.getAbsoluteEncoder();
        //RelativeEncoder WristEnc = CANWrist.getEncoder(); //Not the type we want
    }
private void Burnflash(){
        CANWrist.setCANTimeout(250);
         CANWrist.flashConfiguration(false, IdleMode.kBrake, 25, false);// True for 12V voltage Compensation
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
    return Math.abs(getWrist() - requestSetpoint()) <= OutConstants.WristTolerance; //
    How much tolerance we want
}
private void stopWrist(){
    CANWrist.stopMotor();
}
}