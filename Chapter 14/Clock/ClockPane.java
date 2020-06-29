/*
 * Author: Kaden Payne
 * Date: 6/25/2020
 * 
 * Modifying ClockPane to display or not display the hands
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
/**
 *
 * @author kjpay
 */
public class ClockPane extends Pane {
    //Clock variables
    private int hour;
    private int minute;
    private int second;
    private double w = 250;
    private double h = 250;
    private boolean hourHandVisiable = true;
    private boolean minuteHandVisiable = true;
    private boolean secondHandVisiable = true;
    
    //Constructors
    public ClockPane() {
        setCurrentTime();
    }
    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        drawClock();
    }
    
    //Accessers and mutators for hour, minute, and second
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour;
        drawClock();
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
        drawClock();
    }
    public int getSecond() {
        return second;
    }
    public void setSecond(int second) {
        this.second = second;
        drawClock();
    }
    
    //Accessers and mutators for w and h
    public double getW() {
        return w;
    }
    public void setW(double w) {
        this.w = w;
        drawClock();
    }
    public double getH() {
        return h;
    }
    public void setH(double h) {
        this.h = h;
        drawClock();
    }
    
    //Accessers and mutators for hour/minute/secondHandVisiable
    public boolean istHourHandVisiable() {
        return hourHandVisiable;
    }
    public void setHourHandVisiable(boolean hourHandVisiable) {
        this.hourHandVisiable = hourHandVisiable;
        drawClock();
    }
    public boolean isMinuteHandVisiable() {
        return minuteHandVisiable;
    }
    public void setMinuteHandVisiable(boolean minuteHandVisiable) {
        this.minuteHandVisiable = minuteHandVisiable;
        drawClock();
    }
    public boolean isSecondHandVisiable() {
        return secondHandVisiable;
        
    }
    public void setSecondHandVisiable(boolean secondHandVisiable) {
        this.secondHandVisiable = secondHandVisiable;
        drawClock();
    }
    
    //setCurrentTime method
    public void setCurrentTime() {
        Calendar cal = new GregorianCalendar();
        
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.minute = cal.get(Calendar.MINUTE);
        this.second = cal.get(Calendar.SECOND);
        
        drawClock();
    }
    
    //Drawing the clock
    protected void drawClock() {
        //Variables of the clock
        double clockRadius = Math.min(w, h) * 0.8 * 0.5;
        double xCenter = w / 2;
        double yCenter = h / 2;
        
        //Actually drawing the clock
        Circle circle = new Circle(xCenter, yCenter, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text text1 = new Text(xCenter - 5, yCenter - clockRadius + 12, "12");
        Text text2 = new Text(xCenter - clockRadius + 3, yCenter + 5, "9");
        Text text3 = new Text(xCenter + clockRadius - 10, yCenter +3, "6");
        Text text4 = new Text(xCenter - 3, yCenter + clockRadius - 3, "3");
        
        //Drawing secound hand
        Line sLine = new Line();
        if (secondHandVisiable == true) {
            double sLength = clockRadius * 0.8;
            double xSecond = xCenter + sLength * Math.sin(second * (2 * Math.PI / 60));
            double ySecond = yCenter - sLength * Math.cos(second * (2 * Math.PI / 60));
            sLine = new Line(xCenter, yCenter, xSecond, ySecond);
            sLine.setStroke(Color.RED);
        }
        
        //Drawing minute hand
        Line mLine = new Line();
        if (minuteHandVisiable == true) {
            double mLength = clockRadius * 0.65;
            double xMinute = xCenter + mLength * Math.sin(minute * (2 * Math.PI / 60));
            double yMinute = yCenter - mLength * Math.cos(minute * (2 * Math.PI / 60));
            mLine = new Line(xCenter, yCenter, xMinute, yMinute);
            mLine.setStroke(Color.BLACK);
        }
        
        //Drawing hour hand
        Line hLine = new Line();
        if (hourHandVisiable == true) {
            double hLength = clockRadius * 0.5;
            double xHour = xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            double yHour = yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            hLine = new Line(xCenter, yCenter, xHour, yHour);
            hLine.setStroke(Color.BLUE);
        }
        
        getChildren().clear();
        getChildren().addAll(circle, text1, text2, text3, text4, sLine, mLine, hLine);
    }
}    
