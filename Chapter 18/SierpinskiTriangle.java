/*
 * Author: Kaden Payne
 * Date: 8/21/2020
 * 
 * Modifying SierpinskiTrinangle to change order with buttons
 */
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
/**
 *
 * @author kjpay
 */
public class SierpinskiTriangle extends Application {
    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();
        Button btMinus = new Button("-");
        Button btPlus = new Button("+");
        
        //Setting EventAction to increase or decrease the order
        btMinus.setOnAction(e -> {
            if (trianglePane.getOrder() <= 0) {
                trianglePane.setOrder(0);
            }
            else {
                trianglePane.setOrder(trianglePane.getOrder() - 1);
            }
        });
        btPlus.setOnAction(e -> {
            if (trianglePane.getOrder() >= 8) {
                trianglePane.setOrder(8);
            }
            else {
                trianglePane.setOrder(trianglePane.getOrder() + 1);
            }
        });
        
        //Placing Buttons in a HBox
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btMinus, btPlus);
        
        //Placing everthing in a BorderPane
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(trianglePane);
        borderPane.setBottom(hBox);
        
        //Creating Scene and showing
        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("SierpinskiTriangle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.widthProperty().addListener(ov -> trianglePane.paint());
        scene.heightProperty().addListener(ov -> trianglePane.paint());
    }
    
    //Method for making SierpinskiTriangle
    static class SierpinskiTrianglePane extends Pane {
        private int order = 0;
        
        //Getter and Setter for order
        public int getOrder() {
            return order;
        }
        public void setOrder(int order) {
            this.order = order;
            paint();
        }
        
        //Constuctor
        SierpinskiTrianglePane() {
        }
        
        //Draws the triangle
        protected void paint() {
            //Making the points for the triangle
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
            
            this.getChildren().clear();
            
            displayTriangles(order, p1, p2, p3);
        }
        
        //Making the triangle
        private void displayTriangles(int order, Point2D p1, Point2D p2, Point2D p3) {
            if (order == 0) {
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.GOLD);
                
                this.getChildren().add(triangle);
            }
            else {
                //Getting the midpoints of the triangle
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);
                
                //Display this triangles
                displayTriangles(order - 1, p1, p12, p31);
                displayTriangles(order - 1, p12, p2, p23);
                displayTriangles(order - 1, p31, p23, p3);
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
