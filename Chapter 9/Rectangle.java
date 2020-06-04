/*
 * Author: Kaden Payne
 * Date: 6/3/2020
 * 
 * A rectangle class to make a rectangle object
 */

/**
 *
 * @author kjpay
 */
public class Rectangle {
    //Width and heigth of rectangle
    double width;
    double heigth;
    
    //No-arg contructor
    public Rectangle() {
        width = 1;
        heigth = 1;
    }
    
    //Arg contructor
    public Rectangle(double newWidth, double newHeigth) {
        width = newWidth;
        heigth = newHeigth;
    }
    
    //Area of the rectangle
     public double getArea() {
        return width * heigth;
    }
    
    //Perimeter of the rectangle
    public double getPerimeter() {
        return 2 * (width + heigth);
    }
}
