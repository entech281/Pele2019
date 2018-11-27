package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.SendableBase;


public class DriveForward extends Command{

    private DriveSubsystem drive;
    private double driveForwardSpeed = 0.0;

    public void DriveForwardCommand(DriveSubsystem drive, double driveDistance, double driveFowardSpeed) {
        this.drive = drive;
        this.driveForwardSpeed = driveFowardSpeed;
        requires(drive);
	}
    @Override
	protected void initialize() {
        
	}

	@Override
	protected boolean isFinished() {		
		return isTimedOut();
	}


    }
}