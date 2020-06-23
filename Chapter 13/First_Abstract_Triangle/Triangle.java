/*
 * Author: Kaden Payne
 * Date: 6/22/2020
 * 
 * Triangle subclass of GeometricObjectAbstract
 */

/**
 *
 * @author kjpay
 */
public class Triangle extends GeometricObjectAbstract {
    //variables
    private double side1;
    private double side2;
    private double side3;
    
    //constructors
    public Triangle() {
        super();
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }
    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    //Accesser for side1-3
    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getSide3() {
        return side3;
    }
    
    //methods
    @Override
    public String toString() {
        return super.toString() + "\nside1 is " + side1 + " side2 is " + side2 + " side3 is " + side3 + "\narea is " + this.getArea() + " perimeter is " + this.getPerimeter();
    }
    
    
    @Override
     public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}
