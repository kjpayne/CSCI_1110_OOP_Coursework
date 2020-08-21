
import java.util.Scanner;

/*
 * Author: Kaden Payne
 * Date: 8/21/2020
 * 
 * Reversing a string
 */

/**
 *
 * @author kjpay
 */
public class Reverse_String {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Inputting word to reverse
        System.out.print("Enter word to reverse: ");
        String s = input.next();
        
        //Calling Method
        reverseDisplay(s);
    }
    public static String s = "";
    //Method to reverse the String
    public static void reverseDisplay(String value) {
        
        if (value.length() <= 0) {
            System.out.println(s);
        }
        else {
            s += value.charAt(value.length() - 1);
            value = value.substring(0, value.length() - 1);
            reverseDisplay(value);
        }
        
       
    }
}
