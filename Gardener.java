import kareltherobot.*;
import java.awt.Color;

/**
 * Robot plants one beeper on each corner around the plus shaped pattern 
 * 
 * @author Shruti Srinivasan 
 *   
 *
 * @version 6/16/22
 */
public class Gardener extends Robot
{
    /**
     * Creates a Gardener object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public Gardener (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    
    /* Gardener methods: */
    /**
     * Robot turns 90 degrees clockwise
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    public void moveToPosition()
    {
        turnLeft();
        move();
        move();
        move();
        turnLeft();
    }
    
    public void plantOneCorner()
    {
        moveOneSide();
        putBeeper();
        turnLeft();
        moveOneSide();
    }
    
    public void positionForNextCorner()
    {
        turnRight();
        move();
        turnRight();
    }
    
    public void plantCorners()
    {
        plantOneCorner();
        positionForNextCorner();
        plantOneCorner();
        positionForNextCorner();
        plantOneCorner();
        positionForNextCorner();
        plantOneCorner();
    }
    
    public void moveBack()
    {
        turnRight();
        move();
        move();
        move();
        move();
        turnLeft();
    }
    
    public void doGardening()
    {
        moveToPosition();
        plantCorners();
        moveBack();
    }
    
    public void moveOneSide()
    {
        move();
        move();
        move();
    }
    
}
