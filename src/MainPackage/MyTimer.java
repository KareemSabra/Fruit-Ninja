package MainPackage;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class MyTimer {
    private static MyTimer instance;
    private static Timeline timeline;
    private Text text;
    private String time;
    private int mins = 0, secs = 0, millis = 0;
    private Label timerLabel = new Label();
    boolean sos = true;
    Font labelFont = new Font("verdana",22);


    private void setTime(String time){
        this.time = time;
        timerLabel.setText(time);
    }
    public  Timeline getTimeline() {
        return timeline;
    }

    private MyTimer(){

    }
    public static MyTimer getInstance(){
        if (instance== null) {
            instance = new MyTimer();
        }
        return instance;
    }

    public Label getTimeLabel(){
        setTime("00:00");
        timerLabel.setTextFill(Color.WHITE);
        timerLabel.setFont(labelFont);
        //Timer for timerLabel------------------------------------------------------------------------------------------
        timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change(text);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();
        //--------------------------------------------------------------------------------------------------------------
        return timerLabel;
    }
    private void change(Text text) {
        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        setTime((((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs);
        millis++;
    }
    public void pauseTimer(){
        timeline.pause();
    }
    public void playTimer(){
        timeline.play();
    }
    public void resetTimer(){
        mins = 0;
        secs = 0;
        millis = 0;
        timeline.pause();
        setTime("00:00");
        if(!sos) {
            sos = true;
        }
    }
    public String getcurrentTime() {
        return time;
    }
}