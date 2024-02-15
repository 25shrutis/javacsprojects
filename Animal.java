
/**
 * Abstract class Animal focuses on the type of animal and 
 * includes an abstract method, speak(), to determine what each animal says. 
 * It implements the interface, Comparable, and uses the method, compareTo().
 *
 * @author Shruti Srinivasan 
 * @version 11/12/22
 */
public abstract class Animal implements Comparable
{
    
    private String latinName;
    private String commonName;

    /**
     * Constructor for Animal class which 
     * initializes the instance variables.
     * 
     * @param   laName String variable that instance variable, 
     *                 latinName, is initialized to
     * 
     * @param   coName String variable that instance variable,
     *                 commonName, is initialized to
     */
    public Animal(String laName, String coName)
    {
        latinName = laName;
        commonName = coName;
    }
    
    /**
     * Reutrns the value of the instance variable, latinName.
     * 
     * @return String   the value of latinName
     */
    public String getLatinName()
    {
        return latinName;
    }
    
    /**
     * Returns the value of the instance variable, commonName.
     * 
     * @return String   the value of commonName.
     */
    public String getCommonName()
    {
        return commonName;
    }
    
    /**
     * Mutates the value of the instance variable, latinName.
     * 
     * @param latName   String variable that latinName is set to.
     */
    public void setLatinName(String latName)
    {
        latinName = latName;
    }
    
    /**
     * Mutates the value of the instance variable, commonName.
     * 
     * @param comName   String variable that commonName is set to.
     */
    public void setCommonName(String comName)
    {
        commonName = comName;
    }
    
    /**
     * Returns what the animal says. 
     * 
     * @return String  The value of what the animal says.
     */
    public abstract String speak();
    
    /**
     * Uses Comparable's compareTo method to compare the current object 
     * with Object obj. 
     * 
     * @param obj  Animal object with which to compare
     * @return   0  if the two objects are the same
     *           >0 if "this" object > than obj's object
     *           <0 if "this" object < than obj's object
     *           
     * @throws IllegalArgumentException    if the object does not belong to
     *                                     Animal class
     */
    @Override
    public int compareTo(Object obj)
    {
        String currentName = this.getCommonName();
        if (obj instanceof Animal)
        {
            Animal animal = (Animal) obj;
            return currentName.compareTo(animal.getCommonName());
        }
        throw new IllegalArgumentException("Object does not belong to Animal class");
    }
}

