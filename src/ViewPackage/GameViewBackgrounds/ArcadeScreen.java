package ViewPackage.GameViewBackgrounds;

import ViewPackage.GameEngine;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class ArcadeScreen extends GameScreen {
    private Label timerLabel = new Label();

    private void setTime(String time){
        timerLabel.setText(time);
    }

    public void prepareScene(Stage stage)
    {
        super.prepareScene(stage);
        timerLabel.setTextFill(Color.WHITE);
        VBox box2 = new VBox(timerLabel);
        box2.setAlignment(Pos.TOP_RIGHT);
        //Timer for timerLabel------------------------------------------------------------------------------------------
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int i =1;
            @Override
            public void run() {
                String time = (""+i++);

                    }
                };
        timer.schedule(timerTask,1000 , 1000);





        super.mainPane.getChildren().add(box2);
        super.mainPane.getChildren().add(new GameEngine().getGame(stage));

        Scene scene = new Scene(super.mainPane,1280,720);
        stage.setScene(scene);
        stage.show();

    }
}

