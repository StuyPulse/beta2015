package org.usfirst.frc.team694.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drivetrain {

	private static Drivetrain instance;
	private RobotDrive drivetrain;
	
	private Drivetrain() {
		drivetrain = new RobotDrive(Constants.LEFT_MOTOR_CHANNEL, Constants.RIGHT_MOTOR_CHANNEL);
		drivetrain.setSafetyEnabled(false);
	}
	
	public static Drivetrain getInstance() {
		if (instance == null) {
			instance = new Drivetrain();
		}
		return instance;
	}
	
	public void tankDrive(double leftValue, double rightValue) {
		drivetrain.tankDrive(leftValue, rightValue);
	}
	
	public void tankDrive(Joystick leftStick, Joystick rightStick) {
		double left = leftStick.getY();
		double right = rightStick.getY();
		tankDrive(left, right);
	}
	
	public void reset() {
		tankDrive(0.0, 0.0);
	}
	
}
