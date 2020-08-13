/*
 * Author: Kaden Payne
 * Date: 8/12/2020
 * 
 * Animating a rectangle on a pentagon path
 */
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseButton;
/**
 *
 * @author kjpay
 */
public class Rectangle_On_A_Pentagon extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Creating Pane, Rectangle, and Pentagon
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(0, 0, 45, 30);
        rectangle.setFill(Color.BLUEVIOLET);
        Polygon pentagon = new Polygon();
        pentagon.setFill(Color.WHITE);
        pentagon.setStroke(Color.BLACK);
        
        //adding points to pentagon
        ObservableList<Double> list = pentagon.getPoints();
        final double WIDTH = 400 , HEIGHT = 400;
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;
        int s = 5;
        for (int i = 0; i < s; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / s)); 
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / s));
	}
        pentagon.setRotate(-17.5);
        
        pane.getChildren().addAll(pentagon, rectangle);
        
        //Creating PathTransition
        PathTransition pt = new PathTransition(Duration.millis(5000), pentagon, rectangle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        
        //Creating FadeTransition
        FadeTransition ft = new FadeTransition(Duration.millis(5000), rectangle);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        
        //Control Animation
        pentagon.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                pt.play();
            }
            else if (e.getButton() == MouseButton.SECONDARY) {
                pt.pause();
            }
        });
        
        //Creating scene and stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Rectangle on a Pentagon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
