/*
 * Author: Kaden Payne
 * Date: 6/26/2020
 * 
 * Testing the modifyied ClockPane
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
/**
 *
 * @author kjpay
 */
public class Test_ClockPane extends Application{
    @Override
    public void start(Stage primaryStage) {
        int hour = getRandomNumber(0, 11);
        int minute = getZeroOrThirty();
        
        //Drawing Clock
        ClockPane clock = new ClockPane(hour, minute, 0);
        clock.setSecondHandVisiable(false);
        String time = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label timeLabel = new Label(time);
        
        //Placing Clock in Pane
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(timeLabel);
        BorderPane.setAlignment(timeLabel, Pos.TOP_CENTER);
        
        //Creating scene and stage
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("ClockPane without Second Hand");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    //Randomly picks between 0-11
    public static int getRandomNumber(int num1, int num2) {
        return (int)(num1 + Math.random() * (num2 - num1 + 1));
    }
    //Randomly picks 0 or 30
    public static int getZeroOrThirty() {
        int zeroCount = 0;
        int oneCount = 0;
        
        for (int i = 0; i < 3; i++) {
            if (getRandomNumber(0, 1) == 0) {
                zeroCount++;
            }
            else {
                oneCount++;
            }
        }
        
        if (zeroCount > oneCount) {
            return 0;
        }
        else {
            return 30;
        }
    }
}
