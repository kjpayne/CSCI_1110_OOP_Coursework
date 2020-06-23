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
        System.out.println(oct.compareTo(octClone));
    }
}
