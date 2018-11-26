import.java.util.List;

public class FollowPath extends Command {

    private Drivesubsystem subsystem;
    List<Action> list;

    /*
       When implemented, an Action object should indicate (for Tank Drive) the type of action(through the boolean isTurn) followed by a value indicating how much (i.e. distance; time)

       The Boolean Indicates:
       False = move (forward = positive; backwrd = negative)
       True = turn (cw = positive; ccw = negative)
    */
    public FollowPath(DriveSubsystem subsystem, List<Action> list) {
        this.subsystem = subsystem;
        this.list = list;
    }
    
    protected void initialize() {
    }

    protected void execute() {

        for(Action a:list){
            if(a.isTurn()){

            }
            else{

            }
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