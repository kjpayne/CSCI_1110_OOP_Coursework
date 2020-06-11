/*
 * Author: Kaden Payne
 * Date: 6/4/2020
 * 
 * Creating an object thats an Account
 */

/**
 *
 * @author kjpay
 */
public class Account {
    //ID, balance, annual interest rate, and date created
    private int id;
    private double balance;
    private double annualInterestRate;
    private java.util.Date dateCreated = new java.util.Date();
    
    //Default constructor
    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated.toString();
    }
    
    //Arg constructor
    public Account(int newID, double newBalance, double newAnnualInterestRate) {
        id = newID;
        balance = newBalance;
        annualInterestRate = newAnnualInterestRate;
        dateCreated.toString();
    }
    
    //Accesser and mutator for id
    public int getID() {
        return id;
    }
    public void setID(int newID) {
        id = newID;
    }
    
    //Accesser and mutator for balance
    public double getBalance() {
        return balance;
    }
    public void setBalance(double newBalance) {
        balance = newBalance;
    }
    
    //Accesser and mutator for annual interest rate
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }
    
    //Accesser for date created
    public String getDateCreated() {
        return dateCreated.toString();
    }
    
    //Monthly interest rate and monthly interest
    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) / 12;
    }
    public double getMonthlyInteres() {
        return balance * ((annualInterestRate / 100) / 12);
    }
    
    //Withdraw and deposit
    public void withdraw(double withdrawAmount) {
        balance -= withdrawAmount;
    }
    public void deposit(double depositAmount) {
        balance += depositAmount;
    }
}
