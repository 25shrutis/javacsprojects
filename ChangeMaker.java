 import java.util.Scanner;
/**
 * Simulates a cashier processing a line of customers and their transactions,
 * which involves a pruchase price, cash payment, and change distribution. 
 * 
 * @author Shruti Srinivasan 
 *
 * @version 9/8/2022
 */
public class ChangeMaker 
{
    private Scanner in = new Scanner (System.in);
    /**
     * Constructor for objects of the class ChangeMaker. 
     */
    public ChangeMaker()
    {
        //no variables initialized 
    }
    
    /**
     * Prompts the customer for the purchase price.
     * @return  the purchase amount in cents
     */
    public int askForPurchasePrice()
    {
        System.out.println("Please enter the purchase price: ");
        Scanner in = new Scanner(System.in);
        double userResponse = in.nextDouble();
        in.nextLine();
        int purchaseAmount = (int)(userResponse * 100 + 0.5);
        return purchaseAmount;
    }
    
    /**
     * Prompts the customer for the amount of cash tendered. 
     * @precondition    the price must be a positive value 
     * @param purchaseAmount    an int value which is the purchase 
     * price in cents 
     * @return  the amount of cash in cents
     */
    public int askForCashPaid(int purchaseAmount)
    {
        System.out.println("Please enter the amount of cash paid: ");
        double userResponse = in.nextDouble();
        in.nextLine();
        int cashAmount = (int)(userResponse * 100 + 0.5);
        if (cashAmount < purchaseAmount)
        {
            System.out.println("To add more money, write \"add more\" or "
            + "write \"terminate\" if you would like to terminate");
            String userResp = in.nextLine();
            if (userResp.equals("terminate"))
            {
                cashAmount = -1;
            }
            else
            {
                if (userResp.equals("add more"))
                {
                    while (cashAmount < purchaseAmount)
                    {
                        System.out.println("Please enter the amount of cash paid: ");
                        double userRes = in.nextDouble();
                        in.nextLine();
                        cashAmount = (int)(userRes * 100 + 0.5);
                    }
                }
            }
        }
        return cashAmount;
    }
    
    /**
     * Prints out the transaction and the correct number of 
     * each type of coins. 
     * 
     * @precondition    cash >= purchase and they must both be positive values
     * 
     * @param purchase the cost of the customer's purchased items in cents
     * @param cash  the amount of money the customer gave to cover the 
     * expenses in cents 
     */
    public void giveChange(int purchaseAmount, int cashAmount)
    {
        System.out.printf("\n\nAmount of purchase  = $ %.2f \n",
                            purchaseAmount/100.0);
        System.out.printf("Cash tendered = $ %.2f \n", cashAmount/100.0);
        
        int change = cashAmount - purchaseAmount;
        int dollars = change/100;
        int coinChange = change % 100;
        
        System.out.printf("Change = $ %d.%02d\n",
                           dollars, coinChange);
                        
        int quarters = coinChange/25;
        
        if (dollars > 0)
        {
            System.out.println("Number of dollars: " + dollars);
        }
        
        if (quarters > 0)
        {
            System.out.println("Number of quarters: " + quarters);
            coinChange = coinChange%25;
        }
        
        if (coinChange > 10)
        {
            System.out.println("Number of dimes: " + coinChange/10);
            coinChange = coinChange%10;
        }
        
        if (coinChange > 5)
        {
            System.out.println("Number of nickels: " + coinChange/5);
            coinChange = coinChange%5;
        }
        
        if (coinChange > 0)
        {
            System.out.println("Number of pennies: " + coinChange);
        }
    }
    
    /**
     * Handles one customer's transaction.
     */
    public void interactWithOneCustomer()
    {
        int purchase = askForPurchasePrice();
        int cash = askForCashPaid(purchase);
        if (cash >= purchase)
        {
            giveChange(purchase, cash);
        }
    }
    
    /**
     * Oversees the transactions of all customers.
     */
    public void processAllTransactions()
    {
        boolean anotherCustomer = true;
        while (anotherCustomer)
        {
            interactWithOneCustomer();
            System.out.println("Is there another customer?" +
            " Say true or false.");
            anotherCustomer = in.nextBoolean();
            System.out.println();
        }
        System.out.println("Thanks for shopping!");
    }
    
    /**
     * Creates an object of the ChangeMaker class. 
     *
     * @param args arguments from the command line
     */
    public static void main(String [ ] args)
    {
        ChangeMaker cashier = new ChangeMaker();
        cashier.processAllTransactions();
    }

}
