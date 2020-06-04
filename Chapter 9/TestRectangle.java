/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjpay
 */
public class TestRectangle {
    public static void main(String[] args){
        
        //Creating object number 1 and 2
        Rectangle rec1 = new Rectangle(4, 40);
        Rectangle rec2 = new Rectangle(3.5, 35.9);
        
        System.out.println("Rectangle 1's width, heigth, area, and perimeter are: " + rec1.width + ", " + rec1.heigth + ", " + rec1.getArea() + ", and " + rec1.getPerimeter() + ".");
        System.out.println("Rectangle 2's width, heigth, area, and perimeter are: " + rec2.width + ", " + rec2.heigth + ", " + rec1.getArea() + ", and " + rec2.getPerimeter() + ".");
    }
}
