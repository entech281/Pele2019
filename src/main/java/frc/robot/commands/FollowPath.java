package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.AutonomousAction;

import java.util.List;

public class FollowPath extends Command {

    private DriveSubsystem d;
    private List<AutonomousAction> list;

    public FollowPath(DriveSubsystem d, List<AutonomousAction> list) {
        this.d = d;
        this.list = list;
    }
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    
        for(AutonomousAction a:list){
            d.driveNSeconds(a.getTime(),a.getX(),a.getX(),a.getTheta());
        }
    } 

    @Override
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}