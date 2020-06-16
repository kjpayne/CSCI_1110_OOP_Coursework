/*
 * Author: Kaden Payne
 * Date: 6/4/2020
 * 
 * Testing Account class
 */

/**
 *
 * @author kjpay
 */
import java.util.Scanner;

public class Test_Account {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        //Creating Account objects
        Account account = new Account(1122, 20000.00, 4.5);
        
        //Withdraw and deposit
        account.withdraw(2500);
        account.deposit(3000);
        
        System.out.println("Your balance is: $" + account.getBalance() + "\nYour monthly interest is: $" + account.getMonthlyInteres() + "\nYour account was created on this date: " + account.getDateCreated());
    }
}
