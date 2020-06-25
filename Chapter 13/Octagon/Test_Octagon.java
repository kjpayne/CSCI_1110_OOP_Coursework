/*
 * Author: Kaden Payne
 * Date: 6/23/2020
 * 
 * Testing the Octagon subclass and the Comparable and Cloneable interfaces
 */

/**
 *
 * @author kjpay
 */
public class Test_Octagon {
    public static void main(String[] args) throws CloneNotSupportedException{
        //Creating Octagon object
        Octagon oct = new Octagon(8.0, "blue", true);
        
        //Cloning oct object
        Octagon octClone = (Octagon)oct.clone();
        
        //Comparing the two objects
        switch (oct.compareTo(octClone)) {
            case 1: System.out.println("Octagon 1 is greater than Octagon 2.");
                    break;
            
            case -1: System.out.println("Octagon 2 is greater than Octagon 1.");
                     break;
                     
            case 0: System.out.println("Octagon 1 and Octagon 2 are the same.");
        }
    }
}
