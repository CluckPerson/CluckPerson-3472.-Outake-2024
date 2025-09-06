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

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.Encoder;

public class REVOut {
          /*      TODO:
    Set/Request Position
    Set/Request Setpoint
    Boolean atGoal
    Stop

    What is? From BulukLib
    private ClosedLoopControl pid;
    private ClosedLoopRequest request;
     */
    public SparkMax uh = new SparkMax(1, MotorType.kBrushless);

    SparkAbsoluteEncoder ChongDeity = uh.getAbsoluteEncoder();
    //RelativeEncoder JMDeity = uh.getEncoder(); //Not the type we want
    SparkMaxConfig WristConfig = new SparkMaxConfig();
}
    private void Burnflash(){
        uh.setCANTimeout(250);
         WristConfig.
            inverted(false).
            idleMode(IdleMode.kBrake).
            smartCurrentLimit(25);//limit in Amps
        uh.configure(WristConfig, com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters, PersistMode.kPersistParameters); //couldn't import for some reason
        
    }