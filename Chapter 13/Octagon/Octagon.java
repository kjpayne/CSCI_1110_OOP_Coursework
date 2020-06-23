/*
 * Author: Kaden Payne
 * Date: 6/23/2020
 * 
 * Octagon subclass of the GeometricObject superclass
 */

/**
 *
 * @author kjpay
 */
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
    //variable
    private double side;
    
    //Constructors
    public Octagon() {
        super();
        this.side = 1;
    }
    public Octagon(double side, String color, boolean filled) {
        super(color, filled);
        this.side = side;
    }
    
    //Accesser
    public double getSide() {
        return side;
    }
    
    //toString method
    @Override
    public String toString() {
        return super.toString() + "\nsides are " + side + "\narea is " + this.getArea() + " perimeter is " + this.getPerimeter();
    }
    
    //Area and perimeter
    @Override
    public double getArea() {
        return (2 / 4/Math.sqrt(2)) * side * side;
    }
    @Override
    public double getPerimeter() {
        return 8 * side;
    }
    
    //Comparable and Cloneable
    @Override
    public int compareTo(Octagon o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        }
        else if (this.getArea() < o.getArea()) {
            return -1;
        }
        else {
            return 0;
        }
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
