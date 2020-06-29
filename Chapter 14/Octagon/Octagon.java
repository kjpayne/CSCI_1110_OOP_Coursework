/*
 * Author: Kaden Payne
 * Date: 6/29/2020
 * 
 * Modifying ShowPolygon
 */
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
/**
 *
 * @author kjpay
 */
public class Octagon extends Application{
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.getChildren().add(new MyPolygon());
        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle("ShowPolygon"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
        
    public static void main(String[] args) {
	launch(args);
    }
}

class MyPolygon extends Pane {
    private void paint() {
	// Create a polygon and place polygon to pane
	Polygon polygon = new Polygon();
	polygon.setFill(Color.RED);
	polygon.setStroke(Color.WHITE);
	ObservableList<Double> list = polygon.getPoints();
		
	double centerX = getWidth() / 2, centerY = getHeight() / 2;
	double radius = Math.min(getWidth(), getHeight()) * 0.4;

	// s represents the number of sides of the shape
	// Make sure to update this number when necessary
	int s = 8;
	// Add points to the polygon list
	for (int i = 0; i < s; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
	}
        polygon.setRotate(22.5);
        
	Text text = new Text(100, 230, "STOP");
	text.setFill(Color.WHITE);
        text.setFont(Font.font("Highway Gothic", FontWeight.BOLD, 80));
		
	getChildren().clear();
	getChildren().addAll(polygon, text);
    }
	
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }
	
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}
