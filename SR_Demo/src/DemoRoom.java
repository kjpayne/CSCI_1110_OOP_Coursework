/*
 * Author: Kaden Payne
 * Date: 8/25/2020
 * 
 * Room where the action happens.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.animation.PathTransition;
import javafx.util.Duration;
/**
 * This class runs the panel that the character will be tested on. It makes a pane 
 * that hold the CharacterPane object, a circle, and two lines. The CharacterPane 
 * object is a triangle that is the test character. The circle follows the cursor 
 * as a way to "aim". One line is an "arrow" and the other is the path that the 
 * arrow travels. The character is moved using WASD and the arrow is "shot" with 
 * the click of the mouse. The character rotates by the movement of the cursor and 
 * when it moves around it. The arrow is placed off-screen until the mouse is clicked.
 * @author kjpay
 * @version 1.0
 */
public class DemoRoom extends Application{
    /**
     * This method makes a pane, a CharacterPane object, a circle, and two lines. 
     * The circle, one line called arrow, and CharacterPane is added to the pane 
     * in that order. The CharacterPane called character has a KeyEvent added to it.
     * The event is triggered when W, A, S, or D is pressed. W calls the setAllYUp 
     * method in the CharacterPane class. A calls the setAllXLeft method. S calls 
     * the setAllYDown method. D calls the setAllXRight method. All key press rotate 
     * the triangle to face the cursor and set the StartX and StartY of the line 
     * called pathLine respectively. The pane has two MouseEvent's added to it. 
     * The first event is triggered when the cursor moves. Then triggered, the 
     * circle has its center X and Y values changed to that of the cursor. The 
     * character also rotates with the rotateTriangle method(the key press trigger 
     * this method too). The EndX and EndY of pathLine is changed to that of the 
     * cursor. When the mouse is clicked, it triggers an event. The event rotates 
     * the arrow to match the rotation of the character and a PathTransition is played. 
     * The PathTransistion, or pt, has the Duration of 500 milliseconds and the 
     * path is pathLine with the Node being the arrow. Last but not less, a scene is 
     * made with the pane, the scene is added to the primaryStage, and the primaryStage 
     * gets the title of "SR Demo". The character request focus so that it can read 
     * the keys being pressed.
     * @param primaryStage Where the character, circle, and arrow is displayed
     */
    @Override
    public void start(Stage primaryStage) {
        final int WIDTH = 2000, HEIGHT = 1000;
        Pane pane = new Pane();
        CharacterPane character = new CharacterPane();
        
        //Circle to follow cursor
        Circle circle = new Circle(1940, 200, 20);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.RED);
        pane.getChildren().add(circle);
        
        //Path for arrow and arrow
        Line pathLine = new Line(character.getP1X(), character.getP1Y() + 30, circle.getCenterX(), circle.getCenterY());
        Line arrow = new Line(1940, 100, 1940, 140);
        arrow.setStroke(Color.SILVER);
        arrow.setStrokeWidth(4);
        pane.getChildren().add(arrow);
        
        pane.getChildren().add(character);
        
        //KeyEvents for moving the character
        character.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case W:
                    character.setAllYUp();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartY(character.getP1Y() + 30);
                    break;
                case S:
                    character.setAllYDown();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartY(character.getP1Y() + 30);
                    break;
                case A:
                    character.setAllXLeft();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartX(character.getP1X());
                    break;
                case D:
                    character.setAllXRight();
                    character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
                    pathLine.setStartX(character.getP1X());
                    break;
                default:
                    break;
            }
        });
        
        //Move circle with cursor and rotate character
        pane.setOnMouseMoved(e -> {
            circle.setCenterX(e.getX());
            circle.setCenterY(e.getY());
            character.rotateTriangle(circle.getCenterX(), circle.getCenterY());
            pathLine.setEndX(circle.getCenterX());
            pathLine.setEndY(circle.getCenterY());
        });
        
        //Making arrow animation
        PathTransition pt = new PathTransition(Duration.millis(500), pathLine, arrow);
        pt.setCycleCount(1);
        
        pane.setOnMouseClicked(e -> {
            arrow.setRotate(character.getDegrees());
            pt.play();
        });
        
        //Creating scene and showing stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("SR Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        character.requestFocus();
    }
    
    /**
     * This method launches the primaryStage.
     * @param args What is launched
     */
    //To lanch the stage
    public static void main(String[] args) {
        launch(args);
    }
}
