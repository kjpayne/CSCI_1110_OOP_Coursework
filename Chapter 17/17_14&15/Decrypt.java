/*
 * Author: Kaden Payne
 * Date: 8/20/2020
 * 
 * Decrypting files with 5 after every byte
 */
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author kjpay
 */
public class Decrypt {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        char[] decrypt;
        //Inputting file names
        System.out.print("Enter input file name: ");
        String inputFileName = input.next();
        System.out.print("Enter output file name: ");
        String outputFileName = input.next();
        
        //Making inputFileName a proper file
        inputFileName += ".dat";
        
        //Reading from inputFileName
        try (ObjectInputStream inputEncrypt = new ObjectInputStream(new FileInputStream(inputFileName));) {
            char[] encrypt = (char[]) (inputEncrypt.readObject());
            
            //Decrypter
            decrypt = new char[encrypt.length / 2];
            int index = 0;
            for (int i = 0; i < encrypt.length; i++) {
                if (i % 2 == 0) {
                    decrypt[index] = encrypt[i];
                }
                else {
                    index++;
                }
            }
            //Showing that it was decrypted
            for (int i = 0; i < decrypt.length; i++) {
                System.out.print(decrypt[i]);
            }
            System.out.println();
        }
        
        //Making outputFileName a proper file
        outputFileName += ".dat";
        
        //Writing the decrypted file
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputFileName, true));) {
            output.writeObject(decrypt);
        }
    }
}
