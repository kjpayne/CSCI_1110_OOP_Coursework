/*
 * Author: Kaden Payne
 * Date: 8/18/2020
 * 
 * Creating a file to add 100 random numbers
 */
import java.io.*;
/**
 *
 * @author kjpay
 */
public class Create_Wrtie_File {
    public static void main(String[] args) throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("Exercise17_01.txt", true));) {
            for (int i = 0; i < 100; i++) {
                output.write(getRandomNumber(1, 100));
                output.writeUTF(" ");
            }
        }
    }
    
     public static int getRandomNumber(int num1, int num2) {
        return (int)(num1 + Math.random() * (num2 - num1 + 1));
    }
}
