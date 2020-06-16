/*
 * Author: Kaden Payne
 * Date: 6/16/2020
 * 
 * Saving account subclass off of Account
 */

/**
 *
 * @author kjpay
 */
public class SavingAccount extends Account {
    //Constructors
    public SavingAccount() {
        super();
    }
    public SavingAccount(int id, double balance, double annualInterestRate) {
        super(id, balance, annualInterestRate);
    }
    //Modified withdraw method
    @Override
    public void withdraw(double withdrawAmount) {
        if (withdrawAmount >= super.getBalance()) {
            System.out.println("Withdrawal failed.");
        }
        else {
            super.withdraw(withdrawAmount);
        }
    }
}
