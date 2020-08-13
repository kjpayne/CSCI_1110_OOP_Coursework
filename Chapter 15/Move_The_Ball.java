/*
 * Author: Kaden Payne
 * Date: 8/11/2020
 * 
 * Making a pane with a ball that the user can move
 */
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
/**
 *
 * @author kjpay
 */
public class Move_The_Ball extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Making BroderPane, Hbox, Circle, and Buttons
        final double radius = 20;
        double x = 125, y = 100;
        BorderPane pane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Circle ball = new Circle(x, y, radius);
        ball.setStroke(Color.BLACK);
        ball.setFill(Color.RED);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        
        //adding Actions to Buttons
        btLeft.setOnAction(e -> {
            ball.setCenterX(ball.getCenterX() > 20 ? ball.getCenterX() - 5 : 20);
            ball.requestFocus();
        });
        btRight.setOnAction(e -> {
            ball.setCenterX(ball.getCenterX() < 230 ? ball.getCenterX() + 5 : 230);
            ball.requestFocus();
        });
        btUp.setOnAction(e -> {
            ball.setCenterY(ball.getCenterY() > 20 ? ball.getCenterY() - 5 : 20);
            ball.requestFocus();
        });
        btDown.setOnAction(e -> {
            ball.setCenterY(ball.getCenterY() < 199 ? ball.getCenterY() + 5 : 199);
            ball.requestFocus();
        });
        
        ball.setFocusTraversable(true);
        //adding KeyCode Actions to ball
        ball.setOnKeyPressed(e -> {
           if (e.getCode() == KeyCode.UP) {
               ball.setCenterY(ball.getCenterY() > 20 ? ball.getCenterY() - 5 : 20);
           }
           else if (e.getCode() == KeyCode.DOWN) {
               ball.setCenterY(ball.getCenterY() < 199 ? ball.getCenterY() + 5 : 199);
           }
           else if (e.getCode() == KeyCode.LEFT) {
               ball.setCenterX(ball.getCenterX() > 20 ? ball.getCenterX() - 5 : 20);
           }
           else if (e.getCode() == KeyCode.RIGHT) {
               ball.setCenterX(ball.getCenterX() < 230 ? ball.getCenterX() + 5 : 230);
           }
        });
        
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);
        pane.getChildren().add(ball);
        pane.setBottom(hBox);
        //Creating scene and stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Move The Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        ball.requestFocus();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
