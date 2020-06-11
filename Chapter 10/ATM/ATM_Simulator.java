/*
 * Author: Kaden Payne
 * Date: 6/10/2020
 * 
 * Simulating an ATM
 */
import java.util.Scanner;
/**
 *
 * @author kjpay
 */
public class ATM_Simulator {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        //Accounts
        Account acc0 = new Account(0, 100.00, 0);
        Account acc1 = new Account(1, 100.00, 0);
        Account acc2 = new Account(2, 100.00, 0);
        Account acc3 = new Account(3, 100.00, 0);
        Account acc4 = new Account(4, 100.00, 0);
        Account acc5 = new Account(5, 100.00, 0);
        Account acc6 = new Account(6, 100.00, 0);
        Account acc7 = new Account(7, 100.00, 0);
        Account acc8 = new Account(8, 100.00, 0);
        Account acc9 = new Account(9, 100.00, 0);
        //Array of Accounts
        Account[] accounts = {acc0, acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9};
        //Variables
        int id = 0;
        //Loop variables
        boolean accountID = true;
        boolean atm = true;
        boolean atmSystem = true;
        //Loop that keeps program running
        while (atmSystem == true) {
            while (accountID == true) {
                System.out.print("Enter ID: ");
                id = input.nextInt();
                
                if (id > 0 && id < 9) {
                    accountID = false;
                }
                else {
                    System.out.println("Error, please re-enter ID.");
                }
            }
            while (atm == true) {
                System.out.println("Main Menu\n1. See Balance\n2. Withdraw\n3. Deposit\n4. Exit");
                System.out.print("Enter option: ");
                int option = input.nextInt();
                
                switch (option) {
                    case 1: System.out.printf("$%5.2f\n",  accounts[id].getBalance());
                            break;
                    
                    case 2: System.out.print("Enter amount: ");
                            double withdraw = input.nextDouble();
                            accounts[id].withdraw(withdraw);
                            break;
                    
                    case 3: System.out.print("Enter amount: ");
                            double deposit = input.nextDouble();
                            accounts[id].deposit(deposit);
                            break;
                            
                    case 4: atm = false;
                            break;
                }
            }
            accountID = true;
            atm = true;
        }
    }
}
