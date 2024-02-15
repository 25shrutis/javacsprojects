import java.util.Scanner;
/**
 * Determine if a set of integers is a palindrome. 
 * 
 * @author Mrs. King
 * @author Shruti Srinivasan 
 * @version 7/14/22
 */
public class IntegerPalindrome
{
    // You may not create any instance variables
    // for this assignment.

    /**
     * Constructor for objects of class IntegerPalindrome.
     */
    public IntegerPalindrome()
    {  
    }

    /**
     * Asks user for input, reads it and returns the input.
     * 
     * @return  a number that the user typed in the terminal window
     */
    public int getUserInput( )
    {
        // Instruct the user on how to terminate the session
        System.out.println("\nType in an integer and find out if it is a palindrome." +
                           "\n\tType 999 to stop this portion of the program");
        Scanner in = new Scanner(System.in);
        int y = in.nextInt( );
        in.nextLine();
        return y;
    }

    /**
     * Reverses the digits in a number  
     * I.e., if number = -1234, then it returns -4321
     *
     * @param number the integer that is to be reversed          
     * @return  an integer in which the digits are reversed.
     */
    public int reverseInteger(int number)
    {
        int n = Math.abs(number);
        int reverse = 0;
        while (n > 0)
        {
            reverse = reverse*10 + n%10;
            n = n/10;
        }
        if (number < 0)
        {
            reverse = reverse*(-1);
        }
        return reverse;
    }    

    /**
     * Determines if a series of digits makes a palindrome.
     * 
     * @param  num   a number  
     * @return true  if num is a palindrome;otherwise,
     *         false 
     */
    public boolean isPalindrome(int num)
    {
        if (num == reverseInteger(num))
        {
            return true;
        }
        return false;
    }

    /**
     * This method is the heart of the program.  It checks whether
     * the user's input is a palindrome.  And it outputs the answer. 
     * 
     * @param x an integer
     */
    public void determineIfPalindrome(int x)
    {
        System.out.print(x);
        if (isPalindrome(x))
        {
            System.out.println( " is a palindrome.");
        }
        else
        {
            System.out.println( " is NOT a palindrome.");
        }
    }

    /**
     * Asks user for starting value, reads it and returns the input.
     * 
     * @return  a number
     */
    public int getStart( )
    {
        System.out.print("Enter the starting value");
        int x = getUserInput();
        return x;
    }

    /**
     * Asks user for the last value, reads it and returns the input.
     * 
     * @return  a number
     */
    public int getLast( )
    {
        System.out.print("Enter the last value");
        int y = getUserInput();
        return y;
    }

    /**
     * Count the number of palindrome numbers within a range.  
     * 
     * @param start the starting value to check if it is a palindrome
     * @param stop  the last value to check if it is a palindrome
     * @return count of the integers that are palindromes within the range
     */
    public int countPalindromeNumbersInRange(int start , int stop)
    {
        int count = 0;
        for (int i = start; i <= stop; i++)
        {
            if (isPalindrome(i))
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Generates array of palindrome numbers within a range.  If the range is
     * starts at 11 to end at 111, the return array will be 
     * {11,22,33,44,55,66,77,88,99,101,111}
     * 
     * @param begin the starting value to check if it is a palindrome
     * @param end   the last value to check if it is a palindrome
     * @return array of all integers that are palindromes within the range
     */
    public int[ ] generatePalindromeNumbersInRange(int begin , int end)
    {
        // ... replace the line below to get the count of palindromes
        int total = countPalindromeNumbersInRange(begin,end);
        int [ ] pals = new int[total];
        int index = 0;
        for (int i = begin; i <= end; i++)
        {
            if (isPalindrome(i))
            {
                pals[index] = i;
                index++;
            }
        }
        // ... add code here
        return pals;
    }

    /**
     * Asks the user for a starting number and an ending number.  
     * Prints out all the palindrome numbers between those two 
     * numbers including the start and end values.
     */
    public void processPalindromeNumbersInRange()
    {
        // get palindrome numbers within a range
        int first = getStart();
        int last  = getLast();
        int [] palin = generatePalindromeNumbersInRange(first,last);
        System.out.print("\n\nAll the palindrome numbers between " + first +
            " and " + last + " is:\n\t{");
        for (int i = 0 ; i < palin.length ; i++)
        {
            System.out.print(palin[i]);
            if (i+1 == palin.length)
                System.out.println("}");
            else if (i != 0 && i%10 == 0)
                System.out.print("\n\t");
            else
                System.out.print(", ");
        }
    }

    /**
     * Tests whether the numbers input by the user are palindromes.
     * Then it generates numbers between two numbers input by the user.
     * This code tests the methods in this class.
     * 
     * @param args   information provided by the user at the command line
     */
    public static void main (String [] args)
    {
        IntegerPalindrome pal = new IntegerPalindrome( );
        int userInput = 0 ; 
        while (userInput != 999)
        {
            userInput = pal.getUserInput( );
            pal.determineIfPalindrome(userInput);
        }

        // get palindrome numbers within a range
        pal.processPalindromeNumbersInRange();
    }
}
