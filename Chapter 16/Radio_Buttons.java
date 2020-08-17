/*
 * Author: Kaden Payne
 * Date: 8/14/2020
 * 
 * Moving text with buttons and changing its color with radio buttons
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
/**
 *
 * @author kjpay
 */
public class Radio_Buttons extends Application {
    @Override
    public void start(Stage primaryStage) {
        //Creating BorderPane to place everthing in later
        BorderPane brPane = new BorderPane();
        
        //Creating Text that you will move
        Text text = new Text(155, 75, "Programming is fun!");
        Pane paneWithText = new Pane();
        paneWithText.getChildren().add(text);
        
        //Creating Left and Right Buttons
        Button btLeft = new Button("< Left");
        Button btRight = new Button("Right >");
        HBox hboxForButtons = new HBox();
        hboxForButtons.setSpacing(10);
        hboxForButtons.setAlignment(Pos.CENTER);
        hboxForButtons.setStyle("-fx-border-color: black");
        hboxForButtons.getChildren().addAll(btLeft, btRight);
        
        //ActionEvents set to Left/Right Buttons
        btLeft.setOnAction(e -> text.setX(text.getX() > 0 ? text.getX( )- 10 : 0));
        btRight.setOnAction(e -> text.setX(text.getX() < 315 ? text.getX() + 10 : 315));
        
        //Creating color changing RadioButtons
        RadioButton rdRed = new RadioButton("Red");
        RadioButton rdYellow = new RadioButton("Yellow");
        RadioButton rdBlack = new RadioButton("Black");
        RadioButton rdOrange = new RadioButton("Orange");
        RadioButton rdGreen = new RadioButton("Green");
        HBox hboxForRD = new HBox();
        hboxForRD.setPadding(new Insets(5, 5, 5, 5));
        hboxForRD.setSpacing(10);
        hboxForRD.setAlignment(Pos.CENTER);
        hboxForRD.setStyle("-fx-border-color: black");
        hboxForRD.getChildren().addAll(rdRed, rdYellow, rdBlack, rdOrange, rdGreen);
        
        //adding RadioButtons to ToggleGroup
        ToggleGroup group = new ToggleGroup();
        rdRed.setToggleGroup(group);
        rdYellow.setToggleGroup(group);
        rdBlack.setToggleGroup(group);
        rdOrange.setToggleGroup(group);
        rdGreen.setToggleGroup(group);
        
        //ActionEvents set to RadioButtons
        rdRed.setOnAction(e -> {
           if (rdRed.isSelected()) {
               text.setFill(Color.RED);
           }
        });
        rdYellow.setOnAction(e -> {
            if (rdYellow.isSelected()) {
                text.setFill(Color.YELLOW);
            }
        });
        rdBlack.setOnAction(e -> {
            if (rdBlack.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });
        rdOrange.setOnAction(e -> {
            if (rdOrange.isSelected()) {
                text.setFill(Color.ORANGE);
            }
        });
        rdGreen.setOnAction(e -> {
            if (rdGreen.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });
        
        //adding evething to BorderPane
        brPane.setTop(hboxForRD);
        brPane.getChildren().add(text);
        brPane.setBottom(hboxForButtons);
        
        //Creating Scene and showing Stage
        Scene scene = new Scene(brPane, 450, 150);
        primaryStage.setTitle("Using Radio Buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
