import kareltherobot.*;
import java.awt.Color;

/**
 * Robot must go on a treasure hunt getting clues from each corner with beepers to get to the treasure corner containing five beepers. 
 * 
 * @author Shruti Srinivasan 
 *  
 *
 * @version 6/28/22
 */
public class TreasureHunter6_18 extends Robot
{
    /**
     * Creates a TreasureHunter6_18 object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public TreasureHunter6_18 (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* TreasureHunter6_18 methods: */
    public void turnRight()
    {
        for (int i = 0; i < 3; i++)
        {
            turnLeft();
        }
    }
    
    public void faceEast()
    {
        while (! facingEast())
        {
            turnLeft();
        }
    }
    
    /**
     * Robot moves until it reaches a beeper pile and then it turns a specific direction. 
     * 
     * @precondition robot is not next to a beeper
     * 
     * @postcondition robot moves to the beeper pile, picks up the beeper pile and prepares to move to the next pile
     * /
     */public void followThePath()
    {
        while (! nextToABeeper())
        {
            move();
        }
        pickBeeperPile();
    }
    
    public void faceNorth()
    {
        while (! facingNorth())
        {
            turnLeft();
        }
    }
    
    public void faceWest()
    {
        while (! facingWest())
        {
            turnLeft();
        }
    }
    
    public void faceSouth()
    {
        while (! facingSouth())
        {
            turnLeft();
        }
    }
    
    /**
     * Robot determines how many beepers there are in the beeper pile and faces a direction according to the amount. 
     * 
     * @precondition robot is on the pile with at least one beeper and less than 5 beepers
     * 
     * @postcondition robot has picked up all the beepers on the pile and is facing a direction according to the amount
     * /
     */public void pickBeeperPile()
    {
        pickBeeper();
        if (! nextToABeeper())
        {
            faceNorth();
        }
        else
        {
            pickBeeper();
            if (! nextToABeeper())
            {
                faceWest();
            }
            else 
            {
                pickBeeper();
                if (! nextToABeeper())
                {
                    faceSouth();
                }
                else
                {
                    pickBeeper();
                    if (! nextToABeeper())
                    {
                        faceEast();
                    }
                }
            }
        }
    }  
    
    /**
     * Robot must follow the path until it reaches the pile with 5 beepers.
     * 
     * @precondition robot is facing the first pile of beepers 
     * 
     * @postcondition robot has stopped on the pile with 5 beepers
     * /
     */public void findTreasure()
    {
        while (! nextToABeeper())
        {
            followThePath();
        }
    }
}
