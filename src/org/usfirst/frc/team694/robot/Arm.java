package org.usfirst.frc.team694.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

public class Arm {

	private static Arm instance;
	private Solenoid leftArm;
	private Solenoid rightArm;
	
	private Arm() {
		leftArm = new Solenoid(Constants.PCM_CAN_ID, Constants.LEFT_ARM);
		rightArm = new Solenoid(Constants.PCM_CAN_ID, Constants.RIGHT_ARM);
	}
	
	public static Arm getInstance() {
		if (instance == null) {
			instance = new Arm();
		}
		return instance;
	}
	
	public void armControl(Joystick leftStick, Joystick rightStick) {
		if (leftStick.getRawButton(6)) {
			//boolean position = leftArm.get();
			//leftArm.set(!position);
			leftArm.set(true);
		}
		if (leftStick.getRawButton(7)) {
			//boolean position = rightArm.get();
			//rightArm.set(!position);
			rightArm.set(true);
		}
		if (leftStick.getRawButton(11)) {
			leftArm.set(false);
		}
		if (rightStick.getRawButton(10)) {
			rightArm.set(false);
		}
	}
	
	public boolean getLeftArm() {
		return leftArm.get();
	}
	
	public boolean getRightArm() {
		return rightArm.get();
	}
	
	public void reset() {
		leftArm.set(false);
		rightArm.set(false);
	}
}
