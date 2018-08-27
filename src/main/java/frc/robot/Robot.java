/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  
  private WPI_TalonSRX m_frontLeft  = new WPI_TalonSRX(0);	
	private WPI_TalonSRX m_rearLeft   = new WPI_TalonSRX(2);
	private WPI_TalonSRX m_frontRight = new WPI_TalonSRX(1);	
  private WPI_TalonSRX m_rearRight  = new WPI_TalonSRX(4);
  private MecanumDrive m_robotDrive = new MecanumDrive(m_frontLeft,m_rearLeft,m_frontRight,m_rearRight);
     //Define joystick being used at USB port 1 on the Driver Station
  Joystick m_driveStick = new Joystick(0);

     public void teleopPeriodic(){
          m_robotDrive.driveCartesian(m_driveStick.getX(), m_driveStick.getY(), m_driveStick.getZ());
     }
  
}
