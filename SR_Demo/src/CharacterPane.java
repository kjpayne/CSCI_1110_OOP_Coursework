/*
 * Author/: Kaden Payne
 * Date: 8/25/2020
 * 
 * Pane that will draw the character, character is a triangle.
 */
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.geometry.Point2D;
/**
 * This class creates a pane that makes a triangle. The triangle is created using
 * the Point2D class for the three points of the triangle. There is a getter and 
 * setter for the X and Y of each point. There's also a setter that sets all the 
 * X's together and all the Y's together. This is because the triangle will be 
 * moving up, down, left, and right. The triangle will also rotate by the movement 
 * of the cursor and when it moves around it. There's also a getter for the degrees 
 * because another object needs to be at the same rotation as the triangle.
 * @author kjpay
 * @version 1.0
 */
public class CharacterPane extends Pane{
    //Points for the triangle, triangle, and dergees for rotation
    private Point2D p1 = new Point2D(1000, 470);
    private Point2D p2 = new Point2D(970, 530);
    private Point2D p3 = new Point2D(1030, 530);
    private Polygon triangle;
    private double degrees;
    
    /**
     * This is the constuctor for making an object for this class. It makes the 
     * triangle a new Polygon and adds the X and Y coordinates for p1, p2, and p3. 
     * The triangle's stroke is set to black and the fill is set to green. The 
     * triangle is then added to the pane.
     */
    //Constuctor
    public CharacterPane() {
        this.triangle = new Polygon();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
        triangle.setStroke(Color.BLACK);
        triangle.setFill(Color.GREEN);
        this.getChildren().add(triangle);
    }
    
    /**
     * This is the getter for p1's X value.
     * @return X value of p1
     */
    //Getters and Setters
    public double getP1X() {
        return p1.getX();
    }
    /**
     * This is the getter for p1's Y value.
     * @return Y value of p1
     */
    public double getP1Y() {
        return p1.getY();
    }
    /**
     * This is the setter for p1's X value. It gives p1 a new X coordinate while 
     * keeping its Y coordinate. It then clears all the old points of the triangle 
     * and adds the new points to the triangle. This helps the triangle to move.
     * @param x The new X value for p1
     */
    public void setP1X(double x) {
        this.p1 = new Point2D(x, p1.getY());
        triangle.getPoints().clear();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
    /**
     * This is the setter for p1's Y value. It gives p1 a new Y coordinate while 
     * keeping its X coordinate. It then clears all the old points of the triangle 
     * and adds the new points to the triangle. This helps the triangle to move.
     * @param y The new Y value for p1
     */
    public void setP1Y(double y) {
        this.p1 = new Point2D(p1.getX(), y);
        triangle.getPoints().clear();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
    /**
     * This is the getter for p2's X value
     * @return X value of p2
     */
    public double getP2X() {
        return p2.getX();
    }
    /**
     * This is the getter for p2's Y value
     * @return Y value of p2
     */
    public double getP2Y() {
        return p2.getY();
    }
    /**
     * This is the setter for p2's X value. It gives p1 a new X coordinate while 
     * keeping its Y coordinate. It then clears all the old points of the triangle 
     * and adds the new points to the triangle. This helps the triangle to move.
     * @param x The new X value for p2
     */
    public void setP2X(double x) {
        this.p2 = new Point2D(x, p2.getY());
        triangle.getPoints().clear();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
    /**
     * This is the setter for p2's Y value. It gives p1 a new Y coordinate while 
     * keeping its X coordinate. It then clears all the old points of the triangle 
     * and adds the new points to the triangle. This helps the triangle to move.
     * @param y The new Y value for p2
     */
    public void setP2Y(double y) {
        this.p2 = new Point2D(p2.getX(), y);
        triangle.getPoints().clear();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
    /**
     * This the getter for p3's X value.
     * @return X value of p3
     */
    public double getP3X() {
        return p3.getX();
    }
    /**
     * This is getter for p3's Y value
     * @return Y value of p3
     */
    public double getP3Y() {
        return p3.getY();
    }
    /**
     * This is the setter for p3's X value. It gives p1 a new X coordinate while 
     * keeping its Y coordinate. It then clears all the old points of the triangle 
     * and adds the new points to the triangle. This helps the triangle to move.
     * @param x The new X value for p3
     */
    public void setP3X(double x) {
        this.p3 = new Point2D(x, p3.getY());
        triangle.getPoints().clear();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
    /**
     * This is the setter for p3's Y value. It gives p1 a new Y coordinate while 
     * keeping its X coordinate. It then clears all the old points of the triangle 
     * and adds the new points to the triangle. This helps the triangle to move.
     * @param y The new Y value for p3
     */
    public void setP3Y(double y) {
        this.p3 = new Point2D(p3.getX(), y);
        triangle.getPoints().clear();
        triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
    }
    
    /**
     * This method calls the Y setters of all the points and set the Y value to 
     * 10 minus its current value if the value is greater than 0 or 60 respectively. 
     * If they are less than those values, they are made those values instead. This 
     * moves the triangle up.
     */
    //Moving the Character
    public void setAllYUp() {
        setP1Y(getP1Y() > 0 ? getP1Y() - 10 : 0);
        setP2Y(getP2Y() > 60 ? getP2Y() - 10 : 60);
        setP3Y(getP3Y() > 60 ? getP3Y() - 10 : 60);
    }
    /**
     * This method calls the Y setters of all the points and set the Y value to 
     * 10 plus its current value if the value is less than 940 or 1000 respectively. 
     * If they are greater than those values, they are made those values instead. This 
     * moves the triangle down.
     */
    public void setAllYDown() {
        setP1Y(getP1Y() < 940 ? getP1Y() + 10 : 940);
        setP2Y(getP2Y() < 1000 ? getP2Y() + 10 : 1000);
        setP3Y(getP3Y() < 1000 ? getP3Y() + 10 : 1000);
    }
    /**
     * This method calls the X setters of all the points and set the X value to 
     * 10 minus its current value if the value is greater than 30, 0, or 60 respectively. 
     * If they are less than those values, they are made those values instead. This 
     * moves the triangle to the left.
     */
    public void setAllXLeft() {
        setP1X(getP1X() > 30 ? getP1X() - 10 : 30);
        setP2X(getP2X() > 0 ? getP2X() - 10 : 0);
        setP3X(getP3X() > 60 ? getP3X() - 10 : 60);
    }
    /**
     * This method calls the X setters of all the points and set the X value to 
     * 10 plus its current value if the value is less than 1890, 1960, or 1920 respectively. 
     * If they are greater than those values, they are made those values instead. 
     * This moves the triangle to the right.
     */
    public void setAllXRight() {
        setP1X(getP1X() < 1890 ? getP1X() + 10 : 1890);
        setP2X(getP2X() < 1860 ? getP2X() + 10 : 1860);
        setP3X(getP3X() < 1920 ? getP3X() + 10 : 1920);
    }
    
    /**
     * This rotates the triangle. It takes the center of a circle(cX and cY) and 
     * minus the X and Y of the circle with the X and Y of p1 respectively. The 
     * total distance between the two is calculated by squaring the distance between
     * the X's time itself plus the distance between the Y's time itself. A move 
     * distance is made for the X and Y by dividing the distance of the X and Y 
     * with the total distance. A total move distance is made the same way as the 
     * total distance with using the move distance respectively. A new move distance 
     * is make the same way as the original move distance using the original with 
     * the total. An angle is found between the new move distance and is then converted 
     * to degrees. The triangle's rotation is set to those degrees.
     * @param cX The centerX of a circle
     * @param cY The centerY of a circle
     */
    //Rotating the character
    public void rotateTriangle(double cX, double cY) {
        double distanceX = cX - getP1X();
        double distanceY = cY - getP1Y();
        double distanceTotal = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
        double moveDistanceX = distanceX / distanceTotal;
        double moveDistanceY = distanceY / distanceTotal;
        double totalMove = Math.sqrt(moveDistanceX * moveDistanceX + moveDistanceY * moveDistanceY);
        double newMoveDX = moveDistanceX / totalMove;
        double newMoveDY = moveDistanceY / totalMove;
        double angle = Math.atan2(newMoveDY, newMoveDX);
        degrees = Math.toDegrees(angle) + 90;
        triangle.setRotate(degrees);
    }
    /**
     * The getter for the degrees. It's used to rotate a line in the main class.
     * @return The degrees from the above method
     */
    public double getDegrees() {
        return degrees;
    }
}
