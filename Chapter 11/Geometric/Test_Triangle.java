
import java.util.Scanner;

/*
 * Author: Kaden Payne
 * Date: 6/15/2020
 * 
 * Testing the Triangle subclass
 */

/**
 *
 * @author kjpay
 */
public class Test_Triangle {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        //variables
        double side1;
        double side2;
        double side3;
        String color;
        boolean filled = false;
        //Entering sides, color, and if filled for triangle
        System.out.print("Enter side 1 for triangle: ");
        side1 = input.nextDouble();
        System.out.print("Enter side 2 for triangle: ");
        side2 = input.nextDouble();
        System.out.print("Enter side 3 for triangle: ");
        side3 = input.nextDouble();
        System.out.print("Enter color for triangle: ");
        color = input.next();
        System.out.print("Want the triangle filled? Yes or No: ");
        String yesOrNo = input.next();
        if (yesOrNo.equalsIgnoreCase("Yes")) {
            filled = true;
        }
        else if (yesOrNo.equalsIgnoreCase("No")) {
            filled = false;
        }
        
        //Constructing the triangle
        Triangle tri = new Triangle(side1, side2, side3, color, filled);
        
        System.out.println(tri.toString() + "\nArea = " + tri.getArea() + " and perimeter = " + tri.getPerimeter());
    }    
}
