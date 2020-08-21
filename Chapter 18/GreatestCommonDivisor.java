
import java.util.Scanner;

/*
 * Author: Kaden Payne
 * Date: 8/20/2020
 * 
 * Finding the greatest common divisor using recusion
 */

/**
 *
 * @author kjpay
 */
public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        //Inputting two numbers
        System.out.print("Enter two numbers, bigger number first(space between the two): ");
        int bigNum = input.nextInt();
        int smallNum = input.nextInt();
        
        System.out.println("The Greatest Common Divisor for " + bigNum + " and " + smallNum + " is " + getGCD(bigNum, smallNum));
    }
    
    //Method for finding the GCD
    public static int getGCD(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        else {
            return getGCD(n , m % n);
        }
    }
}
