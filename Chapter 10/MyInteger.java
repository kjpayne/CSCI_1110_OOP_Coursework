/*
 * Author: Kaden Payne
 * Date: 6/8/2020
 * 
 * Making a class that working with ints
 */

/**
 *
 * @author kjpay
 */
public class MyInteger {
    //variable
    private int value;
    
    //Construtor
    public MyInteger(int newValue) {
        value = newValue;
    }
    
    //Accesser
    public int getValue() {
        return value;
    }
    
    //Even, odd, and prime check for object
    public boolean isEven() {
        return value % 2 == 0;
    }
    public boolean isOdd() {
        return value % 2 == 1;
    }
    public boolean isPrime() {
        for (int i = 2; i <= value / 2; i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
    //General even, odd, and prime check
    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
    public static boolean isOdd(int num) {
        return num % 2 == 1;
    }
    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isEven(MyInteger num) {
        return num.getValue() % 2 == 0;
    }
    public static boolean isOdd(MyInteger num) {
        return num.getValue() % 2 == 1;
    }
    public static boolean isPrime(MyInteger num) {
        for (int i = 2; i <= num.getValue() / 2; i++) {
            if (num.getValue() % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    //Equal methods
    public boolean equals(int num) {
        return value == num;
    }
    public boolean equals(MyInteger num) {
        return value == num.getValue();
    }
    
    //Convertor
    public static int parseInt(char[] toInt) {
        return Integer.parseInt(String.valueOf(toInt));
    }
    public static int parseInt(String toInt) {
        return Integer.parseInt(toInt);
    }
}
