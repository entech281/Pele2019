import java.util.List;

public class FollowPath extends Command {

    private Drivesubsystem subsystem;
    private List<AutonomousAction> list;

    public FollowPath(DriveSubsystem subsystem, List<AutonomousAction> list) {
        this.subsystem = subsystem;
        this.list = list;
    }
    
    protected void initialize() {
    }

    protected void execute() {
        double x = AutonomousAction.getx();
        double y = AutonomousAction.gety();
        double theta = AutonomousAction.getTheta();
        double time = AutonomousAction.getTime();

        for(AutonomousAction a:list){
            DriveSubsystem.drive(x,y,theta,time);
        }
    } 

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}