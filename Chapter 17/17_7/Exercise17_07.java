/*
 * Author: Kaden Payne
 * Date: 8/19/2020
 * 
 * Modifying by adding a void function to read the loans and display the total loan amount
 */
import java.io.*;
/**
 *
 * @author kjpay
 */
public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        //Creating Loan Objects
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        //Creating file output and input
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));) {
            output.writeObject(loan1);
            output.writeObject(loan2);
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
        
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat"));) {
            while (true) {
                outputData(input);
            }
        }
        catch (EOFException ex) {
            System.out.println("All data were read");
        }
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
    }
    
    public static void outputData(ObjectInputStream input) throws IOException, ClassNotFoundException {
        Loan loan = (Loan)(input.readObject());
        System.out.println(loan.getTotalPayment());
    }
}
