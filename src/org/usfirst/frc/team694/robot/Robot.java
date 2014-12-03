package org.usfirst.frc.team694.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	PowerDistributionPanel pdp;
	Joystick leftStick = new Joystick(Constants.LEFT_JOYSTICK);
	Joystick rightStick = new Joystick(Constants.RIGHT_JOYSTICK);

	Drivetrain drivetrain;
	Arm arm;

	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	drivetrain = Drivetrain.getInstance();
    	arm = Arm.getInstance();
    	pdp = new PowerDistributionPanel();
    }
    
    /**
     * This function is run once each time the robot enters autonomous mode
     */
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	drivetrain.tankDrive(1.0, 1.0);
    }
    
    /**
     * This function is called once each time the robot enters tele-operated mode
     */
    public void teleopInit(){
    	resetAll();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drivetrain.tankDrive(leftStick, rightStick);
        arm.armControl(leftStick, rightStick);
        updateDashboard();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.run();
    }
    
    private void resetAll() {
    	drivetrain.reset();
    }
    
    private void updateDashboard() {
    	SmartDashboard.putNumber("Left Joystick X", leftStick.getX());
    	SmartDashboard.putNumber("Left Joystick Y", leftStick.getY());
    	SmartDashboard.putNumber("Left Joystick Z", leftStick.getZ());

    	SmartDashboard.putNumber("Right Joystick X", rightStick.getX());
    	SmartDashboard.putNumber("Right Joystick Y", rightStick.getY());
    	SmartDashboard.putNumber("Right Joystick Z", rightStick.getZ());
    	
    	//SmartDashboard.putBoolean("Left Arm Value", arm.getLeftArm());
    	//SmartDashboard.putBoolean("Right Arm Value", arm.getRightArm());

    	
    	/* Print out Amps for each channel in PDP
    	 * There are 16 channels, zero-based */
    	for (int i=0; i<16; i++) {
    		SmartDashboard.putNumber("PDP Channel " + i + " Amps", pdp.getCurrent(i));
    	}
    	SmartDashboard.putNumber("PDP Temperature", pdp.getTemperature());
    	SmartDashboard.putNumber("PDP Voltage", pdp.getVoltage());
    }
    
}
