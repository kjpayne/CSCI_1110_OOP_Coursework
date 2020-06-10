/*
 * Author: Kaden Payne
 * Date: 6/9/2020
 * 
 * Testing the MyInteger class
 */

/**
 *
 * @author kjpay
 */
public class Test_MyInteger {
    public static void main(String[] args){
        //Creatting even, odd, and prime objects
        MyInteger evenInt = new MyInteger(22);
        MyInteger oddInt = new MyInteger(33);
        MyInteger primeInt = new MyInteger(31);
        
        //Checking if even, odd, or prime
        System.out.println("Is " + evenInt.getValue() + " even? " + evenInt.isEven() + "\nIs " + oddInt.getValue() + " even? " + oddInt.isEven() + "\nIs " + primeInt.getValue() + " even? " + primeInt.isEven());
        System.out.println("\nIs " + evenInt.getValue() + " odd? " + evenInt.isOdd() + "\nIs " + oddInt.getValue() + " odd? " + oddInt.isOdd() + "\nIs " + primeInt.getValue() + " odd? " + primeInt.isOdd());
        System.out.println("\nIs " + evenInt.getValue() + " prime? " + evenInt.isPrime() + "\nIs " + oddInt.getValue() + " prime? " + oddInt.isPrime() + "\nIs " + primeInt.getValue() + " prime? " + primeInt.isPrime());
        
        //Other even, odd, prime checks
        System.out.println("\nIs 28 even? " + MyInteger.isEven(28) + "\nIs 55 even? " + MyInteger.isEven(55) + "\nIs 11 even? " + MyInteger.isEven(11));
        System.out.println("\nIs 28 odd? " + MyInteger.isOdd(28) + "\nIs 55 odd? " + MyInteger.isOdd(55) + "\nIs 11 odd? " + MyInteger.isOdd(11));
        System.out.println("\nIs 28 prime? " + MyInteger.isPrime(28) + "\nIs 55 prime? " + MyInteger.isPrime(55) + "\nIs 11 prime? " + MyInteger.isPrime(11));
        
        System.out.println("\nIs " + evenInt.getValue() + " even? " + MyInteger.isEven(evenInt) + "\nIs " + oddInt.getValue() + " even? " + MyInteger.isEven(oddInt) + "\nIs " + primeInt.getValue() + " even? " + MyInteger.isEven(primeInt));
        System.out.println("\nIs " + evenInt.getValue() + " odd? " + MyInteger.isOdd(evenInt) + "\nIs " + oddInt.getValue() + " odd? " + MyInteger.isOdd(oddInt) + "\nIs " + primeInt.getValue() + " odd? " + MyInteger.isOdd(primeInt));
        System.out.println("\nIs " + evenInt.getValue() + " prime? " + MyInteger.isPrime(evenInt) + "\nIs " + oddInt.getValue() + " prime? " + MyInteger.isPrime(oddInt) + "\nIs " + primeInt.getValue() + " prime? " + MyInteger.isPrime(primeInt));
        
        //Checking equals
        System.out.println("\nDoes 28 equal " + evenInt.getValue() + "? " + evenInt.equals(28) + "\nDoes 33 equal " + oddInt.getValue() + "? " + oddInt.equals(33));
        System.out.println("Does " + oddInt.getValue() + " equal " + primeInt.getValue() + "? " + oddInt.equals(primeInt));
        
        //Converting chars and Strings
        char[] num1 = {'1', '0', '1', '0'};
        String num2 = "10100";
        
        System.out.println("\nNum1 converted to int. " + MyInteger.parseInt(num1));
        System.out.println("Num2 converted to int. " + MyInteger.parseInt(num2));
    }
}
