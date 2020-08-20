
import java.io.*;

/*
 * Author: Kaden Payne
 * Date: 8/18/2020
 * 
 * Summing up all the integers in a binary file
 */

/**
 *
 * @author kjpay
 */
public class Sum_Of_Ints {
    public static void main(String[] args) throws IOException {
        //Creating Excercise17_03.dat and adding 100 random numbers between 1-100 to the file
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_03.dat", true));) {
            for (int i = 0; i < 100; i++) {
                output.writeInt(getRandomNumber(1, 100));
                output.writeUTF(" ");
            }
        }
        //Reading and displaying the numbers from the file. Also summing up the numbers and displaying
        try (DataInputStream input = new DataInputStream(new FileInputStream("Exercise17_03.dat"));) {
            for (int i = 0; i < 100; i++) {
                System.out.print(input.readInt() + input.readUTF());
            }
            System.out.println();
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += input.readInt();
            }
            System.out.println("The sum of the integers is " + sum);
        }
    }
    
    public static int getRandomNumber(int num1, int num2) {
        return (int)(num1 + Math.random() * (num2 - num1 + 1));
    }
}
