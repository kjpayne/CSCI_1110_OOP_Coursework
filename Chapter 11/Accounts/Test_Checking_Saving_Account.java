/*
 * Author: Kaden Payne
 * Date: 6/16/2020
 * 
 * Testing the subclasses Checking and Saving Accounts
 */

/**
 *
 * @author kjpay
 */
public class Test_Checking_Saving_Account {
    public static void main(String[] args){
        //Accounts
        Account acc = new Account(1, 1000.00, 2.5);
        CheckingAccount checkAcc = new CheckingAccount(10, 1000.00, 2.5, 200.00);
        SavingAccount saveAcc = new SavingAccount(11, 1000.00, 2.5);
        
        //toString
        System.out.println(acc.toString());
        System.out.println(checkAcc.toString());
        System.out.println(saveAcc.toString());
        
        //Testing Checking Account
        System.out.println("\nChecking account balance is $" + checkAcc.getBalance());
        checkAcc.withdraw(500.00);
        System.out.println("Checking account balance is $" + checkAcc.getBalance());
        checkAcc.withdraw(700.00);
        System.out.println("Checking account balance is $" + checkAcc.getBalance());
        
        //Testing Saving Account
        System.out.println("\nSaving account balance is $" + saveAcc.getBalance());
        saveAcc.withdraw(500.00);
        System.out.println("Saving account balance is $" + saveAcc.getBalance());
        saveAcc.withdraw(700.00);
        System.out.println("Saving account balance is $" + saveAcc.getBalance());
    }
}
