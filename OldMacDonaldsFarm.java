import java.util.*;

/**
 * The main class that is the tester. 
 * 
 * @author Shruti Srinivasan 
 *
 * @version 11/12/22
 */
public class OldMacDonaldsFarm 
{
    private String farmerName;
    private ArrayList<Animal> farmAnimals;
    /**
     * Default constructor for the objects of the OldMacDonaldsFarm class. 
     */
    public OldMacDonaldsFarm()
    {
        farmerName = "OldMacDonald";
        farmAnimals = new ArrayList<Animal>();
    }

    /**
     * The main method for the OldMacDonaldsFarm class.
     * 
     * @param args  array of String objects
     */
    public static void main(String [] args)
    {
        OldMacDonaldsFarm singer = new OldMacDonaldsFarm();
        singer.farmAnimals.add(new Chicken());
        singer.singVerse();
        singer.farmAnimals.add(new Chick());
        singer.singVerse();
        singer.farmAnimals.add(new Rooster());
        singer.singVerse();
        singer.farmAnimals.add(new Pig());
        singer.singVerse();
    }

    /**
     * Prints out the verse for each object of the array list. 
     */
    public void singVerse()
    {
        String phrase1 = farmerName + " had a farm,";
        String ei = " E-I-E-I-O.";
        for (int i = farmAnimals.size(); i > 0; i--)
        {
            String phrase2 = " and on his farm he had some " + 
                farmAnimals.get(i-1).getCommonName() + "," + ei;
            String speak = farmAnimals.get(i-1).speak();
            String doubleSpeak = speak + "-" + speak;
            if (i == farmAnimals.size())
            {
                System.out.println(phrase1 + ei + phrase2);
                System.out.println("With a " + doubleSpeak + " here, and a " + 
                    doubleSpeak + " there,");
                System.out.println("Here a " + speak + ", there a " + 
                    speak + ", every where a " + doubleSpeak + ",");
            }
            if (i < farmAnimals.size())
            {
                System.out.println("With a " + doubleSpeak + " here, and a " + 
                    doubleSpeak + " there,");
                System.out.println("Here a " + speak + ", there a " + 
                    speak + ", every where a " + doubleSpeak + ",");
            }
        }
        System.out.println(phrase1 + ei);
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
