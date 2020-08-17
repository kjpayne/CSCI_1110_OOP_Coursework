/*
 * Author: Kaden Payne
 * Date: 8/14/2020
 * 
 * A stopwatch that will play music
 */
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/**
 *
 * @author kjpay
 */
public class Stopwatch extends Application {
    int num;
    
    @Override
    public void start(Stage primaryStage) {
        //Creating Pane and TextField
        BorderPane pane = new BorderPane();
        TextField number = new TextField("Enter seconds here");
        number.setAlignment(Pos.CENTER);
        number.setFont(Font.font(24));
        pane.setCenter(number);
        
        //Adding Media and MediaPlayer
        final String MEDIA_URL = "https://liveexample.pearsoncmg.com/common/audio/anthem/anthem0.mp3";
        Media media = new Media(MEDIA_URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(Timeline.INDEFINITE);
        
        //ActionEvent to countdown
        EventHandler<ActionEvent> eventHandler = e -> {
            if (num > 0) {
                num--;
                number.setText(Integer.toString(num));
                mediaPlayer.stop();
                number.setEditable(false);
            }
            else {
                mediaPlayer.play();
                number.setEditable(true);
            }
        };
        Timeline counter = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
        
        number.setOnAction(e -> {
            num = Integer.parseInt(number.getText());
            counter.setCycleCount(num + 1);
            counter.play();
        });
        
        //Creating Scene and showing Stage
        Scene scene = new Scene(pane, 300, 100);
        primaryStage.setTitle("Stopwatch");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
