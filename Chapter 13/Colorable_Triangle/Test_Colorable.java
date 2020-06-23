/*
 * Author: Kaden Payne
 * Date: 6/22/2020
 * 
 * Testing the Colorable interface
 */

/**
 *
 * @author kjpay
 */
public class Test_Colorable {
    public static void main(String[] args){
        //Array of GeometricObjects
        Triangle tri1 = new Triangle(5.0, 5.0, 8.0, "green", true);
        Triangle tri2 = new Triangle(8.0, 5.0, 5.0, "purple", true);
        Triangle tri3 = new Triangle(5.0, 8.0, 8.0, "pink", false);
        Triangle tri4 = new Triangle(7.0, 5.0, 8.0, "blue", true);
        Triangle tri5 = new Triangle(6.0, 8.0, 10.0, "orange", false);
        Triangle[] triangle = {tri1, tri2, tri3, tri4, tri5};
        
        for (int i = 0; i < triangle.length; i++) {
            System.out.println("The area of triangle " + (i + 1) + " is " + triangle[i].getArea());
            if (triangle[i] instanceof Colorable) {
                triangle[i].howToColor();
            }
        }
    }
}
