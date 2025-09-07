package frc.robot.Outake;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Wheels {
    /*      TODO:
      Add JM's code. After this, we can make the constants
    */    
    static SparkMax Wheel1 = new SparkMax(OutConstants.Wheel1_ID, MotorType.kBrushless);
    static SparkMax Wheel2 = new SparkMax(OutConstants.Wheel2_ID, MotorType.kBrushless);
    static boolean BranchTest;  



  private void stopOut(){
    Wheel1.stopMotor();
    Wheel2.stopMotor();
  }
}
