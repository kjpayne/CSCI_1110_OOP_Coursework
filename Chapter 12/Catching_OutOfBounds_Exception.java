
import java.util.Scanner;

/*
 * Author: Kaden Payen
 * Date: 6/18/2020
 * 
 * An array program that catchs ArrayIndexOutOfBoundsException
 */

/**
 *
 * @author kjpay
 */
public class Catching_OutOfBounds_Exception {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Array with 100 random numbers
        int[] array = new int[100];
        for(int i = 0; i < array.length; i++) {
            array[i] = getRandomNumber(1, 100);
        }
        try {
            System.out.print("Enter a number (0-99): ");
            int index = input.nextInt();
            
            System.out.println("The number at index " + index + " is " + array[index]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Out of Bounds");
        }
    }
    public static int getRandomNumber(int num1, int num2) {
        return (int)(num1 + Math.random() * (num2 - num1 + 1));
    }
}
