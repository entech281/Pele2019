package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import java.util.List;
import java.util.LinkedList;

public class DriveSubsystem extends Subsystem{
    private class timedCommand{
        public double x;
        public double y;
        public double z;
        public double time;
        timedCommand(double x,double y,double z,double  time){
            this.x=x;
            this.y=y;
            this.z=z;
            this.time=time;
        }
    }
    private WPI_TalonSRX m_frontLeft  = new WPI_TalonSRX(4);
    private WPI_TalonSRX m_rearLeft   = new WPI_TalonSRX(3);
    private WPI_TalonSRX m_frontRight = new WPI_TalonSRX(2);	
    private WPI_TalonSRX m_rearRight  = new WPI_TalonSRX(1);
    private MecanumDrive m_robotDrive = new MecanumDrive(m_frontLeft,m_rearLeft,m_frontRight,m_rearRight);
    private Timer driveTimer          = new Timer();
    private List<timedCommand> commandStack = new LinkedList<timedCommand>();
    @Override
    protected void initDefaultCommand() {
        driveTimer.start();
        driveTimer.reset();
        m_frontLeft.setInverted(true);
    }
    public void drive(double x, double y, double theta){
        m_robotDrive.driveCartesian(x, y, theta);
    }
    
    public void driveNSeconds(double n, double x, double y, double theta){
        commandStack.add(new timedCommand(x, y, theta, n));
    }
    @Override
    public void periodic() {
        if( commandStack.isEmpty()){
            timedCommand currentCommand = commandStack.get(0);
            if(!driveTimer.hasPeriodPassed(currentCommand.time)){
                drive(currentCommand.x,currentCommand.y,currentCommand.z);
            }else{
                commandStack.remove(0);
                driveTimer.reset();
            }
        }
    }

    public boolean isDoneWithStack(){
        return commandStack.isEmpty();
    }
}