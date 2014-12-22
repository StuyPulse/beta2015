package org.usfirst.frc694.Michael1BetaCBP.subsystems;

import org.usfirst.frc694.Michael1BetaCBP.Constants;
import org.usfirst.frc694.Michael1BetaCBP.commands.ResetSensors;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RoboSensors extends Subsystem {

	//AxisCamera camera;
	Gyro betaGyro = new Gyro(Constants.GYRO_CHANNEL);
	BuiltInAccelerometer roboAccelerometer = new BuiltInAccelerometer();
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ResetSensors());
    }
    
    public void reset() {
    	betaGyro.reset();
    }
    
    public double getGyroAngle() {
    	return betaGyro.getAngle();
    }
    
    public double getGyroRate() {
    	return betaGyro.getRate();
    }
    
    public double getBuiltinAccelerometerX() {
    	return roboAccelerometer.getX();
    }
    
    public double getBuiltinAccelerometerY() {
    	return roboAccelerometer.getY();
    }
    
    public double getBuiltinAccelerometerZ() {
    	return roboAccelerometer.getZ();
    }
    
    
    
}
