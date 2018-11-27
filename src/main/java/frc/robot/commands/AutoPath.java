package frc.robot.commands;

import java.util.List;
import java.util.ArrayList;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Position;



public class AutoPath extends Position{




    public List<Position> createAutoPath(){
        PositionCalculator.go(10,10,0).go(10,10,0).right(90).build();
    }
}