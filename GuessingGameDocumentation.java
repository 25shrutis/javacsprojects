import java.util.Scanner;

/**
 * 
 * The guessing game selects a randomn number between two values and gets the user to guess it. The computer responds with "too high", "too low", 
 * or "just right".
 * 
 * @author Shruti Srinivasan  
 * @version 8/30/2022
 */
public class GuessingGameDocumentation
{
    // Only one instance variableis permitted in this class.
    private int rand;  // random number, every instance variable is private (what an object remembers about itself) 

    /**
     * Constructs an object of the class GuessingGameDocumentation
     */
    public GuessingGameDocumentation() //constructor creates instances in class, same name as a class and no return type
    {
        // initialise instance variables
        rand = 0;
    }

    /**
     * Generates a random number between 1 and 100, inclusive. 
     * @return a random number between 1 and 100, inclusive.
     */
    public int generateRandomNumber( )
    {
        rand = (int)(Math.random() * 100)+1;
        return rand;
    }

    /**
     * Prompts the user to guess a number between 1 and 100 and
     * the user's input is returned. 
     * @return the user's guess
     */
    public int askForUserGuess( )
    {
        System.out.print("Guess a number between 1 and 100: ");
        Scanner in = new Scanner (System.in); //in is the object, Scanner is the constructor
        int guess = in.nextInt( ); //paranthesis tell us that it is the method 
        return guess;
    }

    /**
     * Tells the user if the number guessed is too low, too high, or correct.
     * @param guess     the user's guess 
     */
    public void giveUserFeedback(int guess)
    {
         if (guess != rand)
         {
             if (guess > rand)
             {
                 System.out.println(guess + " is too high");
             }
             else
             {
                 if (guess < rand)
                 {
                     System.out.println(guess + " is too low");
                 }
             }
         }
         else
         {
             System.out.println(guess + " is correct!");
         }
    }

    /**
     * Determines if the random number is equal to the user's input. 
     * @param userGuess     the user's guesstimate
     * @return true if the user's guess is correct; otherwise, 
     *         false
     */
    public boolean isWinner(int userGuess)
    {
        if (rand == userGuess)
        {
            return true;
        }
        return false;
    }

    /**
     * Oversees the guessing game. 
     * @param args - information from the command line
     */
    public static void main(String [ ] args)
    
    {
        GuessingGameDocumentation bob = new GuessingGameDocumentation( );
        bob.generateRandomNumber( );
        int est = bob.askForUserGuess( );
        bob.giveUserFeedback(est);
        while ( ! bob.isWinner(est) )
        {
            est = bob.askForUserGuess( );
            bob.giveUserFeedback(est);
        }
    }

}
