
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Author: Kaden Payne
 * Date: 6/18/2020
 * 
 * Writing and reading 100 random numbers into a file
 */

/**
 *
 * @author kjpay
 */
public class Wrtie_Read_Data {
    public static void main(String[] args) throws FileNotFoundException{
        
        //Creating file called Exercise12_15.txt
        java.io.File file = new java.io.File("Exercise12_15.txt");
        if (file.exists()) {
            System.out.println("File already exists.");
            System.exit(1);
        }
        
        //Inputting 100 random numbers
        try ( //Creating PrintWriter for file
                java.io.PrintWriter output = new java.io.PrintWriter(file)) {
            //Inputting 100 random numbers
            for(int i = 0; i < 100; i++) {
                output.print(getRandomNumber(1, 100) + " ");
            }
        }
        
        //Reading the 100 random numbers
        try ( //Creating Scanner for file
                Scanner input = new Scanner(file)) {
            //Reading the 100 random numbers
            while(input.hasNext()) {
                int[] nums = new int[100];
                for (int i = 0; i < nums.length; i++) {
                    nums[i] = input.nextInt();
                }
                for (int i = 0; i < nums.length - 1; i++) {
                    int currentMin = nums[i];
                    int currentMinIndex = i;
                    for (int j = i + 1; j < nums.length; j++) {
                        if (currentMin > nums[j]) {
                            currentMin = nums[j];
                            currentMinIndex = j;
                        }
                    }
                    if (currentMinIndex != i) {
                        nums[currentMinIndex] = nums[i];
                        nums[i] = currentMin;
                    }
                }
                for (int i = 0; i < nums.length; i++) {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
    public static int getRandomNumber(int num1, int num2) {
        return (int)(num1 + Math.random() * (num2 - num1 + 1));
    }
}
