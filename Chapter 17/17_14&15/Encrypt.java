
import java.io.*;
import java.util.Scanner;

/*
 * Author: Kaden Payne
 * Date: 8/19/2020
 * 
 * Encrypting files by adding 5 to every byte
 */

/**
 *
 * @author kjpay
 */
public class Encrypt {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        
        //Inputting file names
        System.out.print("Enter input file name: ");
        String inputFileName = input.next();
        System.out.print("Enter output file name: ");
        String outputFileName = input.next();
        
        //Encrypting inputFileName with 5's
        char[] encrypt = new char[inputFileName.length() * 2];
        int nameIndex = 0;
        for (int i = 0; i < encrypt.length; i++) {
            char five = '5';
            if (i % 2 == 0) {
                encrypt[i] = inputFileName.charAt(nameIndex);
            }
            else {
                encrypt[i] = five;
                nameIndex++;
            }
        }
        //Showing that it was encrypted
        for (int i = 0; i < encrypt.length; i++) {
            System.out.print(encrypt[i]);
        }
        System.out.println();
        
        //Making outputFileName into a proper file name
        outputFileName += ".dat";
        
        //Writing the inputFileName into the outFileName
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputFileName, true));) {
            output.writeObject(encrypt);
        }
    }
}
