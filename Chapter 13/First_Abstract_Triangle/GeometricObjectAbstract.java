/*
 * Author: Kaden Joseph Payne
 * Date: 6/22/2020
 * 
 * Geometric Objects with abstract getArea and getPerimeter
 */

/**
 *
 * @author kjpay
 */
public abstract class GeometricObjectAbstract {
    //variables
    private String color;
    private boolean filled;
    private java.util.Date dateCreated = new java.util.Date();
    
    //constructors
    public GeometricObjectAbstract() {
        this.color = "red";
        this. filled = true;
        dateCreated.toString();
    }
    public GeometricObjectAbstract(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated.toString();
    }
    
    //Accesser and mutator for color
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    
    //Accesser and mutator for filled
    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    //Accesser for dateCreated
    public String getDateCreated() {
        return dateCreated.toString();
    }
    
    //toString method
    @Override
    public String toString() {
        return "Object created on " + dateCreated.toString() + "\ncolor is " + color + " and filled: " + filled;
    }
    //Abstract getArea and getPerimeter
    public abstract double getArea();
    
    public abstract double getPerimeter();
}
