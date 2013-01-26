/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    RobotDrive robot = new RobotDrive(1, 2);
    Joystick joy1= new Joystick(1);
    Joystick joy2= new Joystick(2);
    public void autonomous() {
        //I CAN EDIT NOW
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public boolean setDeadZone(double deadzonevalue, Joystick joy){
        if (Math.abs(joy.getY())<=deadzonevalue){ 
           return true;
        }
        else if(Math.abs(joy.getY())>deadzonevalue){
            return false;
        }
        return false;
    }
    
    public void operatorControl() {
        while(true && isOperatorControl() && isEnabled()){
           tankControl(0.4);
          // System.out.println("LOL");
           Timer.delay(.005);
        }
    }
    
    public void arcadeControl(double deadzone) {
      
    }
    
    public void tankControl(double deadzone) {
      double left=0,right =0;
      System.out.println(joy1.getY() + " , " + joy2.getY());
      if(setDeadZone(deadzone, joy1)) {
          left = 0;
      }
      else {
          left = joy1.getY();
      }
      if(setDeadZone(deadzone,joy2)) {
          right = 0;
      }
      else {
          right = joy2.getY();
      }
      robot.tankDrive(left, right);
    }

    
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void test() {
    //Jesus be coming back here boy
    }
}
