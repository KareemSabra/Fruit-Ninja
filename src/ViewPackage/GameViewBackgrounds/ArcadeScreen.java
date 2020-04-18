package ViewPackage.GameViewBackgrounds;

import MainPackage.MyTimer;
import ViewPackage.GameEngine;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class ArcadeScreen extends GameScreen {
    private Timeline timeline = new Timeline();



    public void prepareScene(Stage stage)
    {
        super.prepareScene(stage);

        VBox box2 = new VBox(MyTimer.getInstance().getTimeLabel());
        box2.setAlignment(Pos.TOP_RIGHT);
        //Timer for timerLabel------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------

        super.mainPane.getChildren().add(box2);
        GameEngine gameEngine = new GameEngine();
        gameEngine.setArcadeTimeline(timeline);
        super.mainPane.getChildren().add(gameEngine.getGame(stage));

        Scene scene = new Scene(super.mainPane,1280,720);
        stage.setScene(scene);
        stage.show();

    }

    }


