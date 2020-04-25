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



    public void prepareScene(Stage stage)
    {
        super.prepareScene(stage);
        StackPane gamePane = new StackPane();
        GameEngine gameEngine = new GameEngine();
        gamePane.getChildren().add(gameEngine.getGame(stage));
        super.mainPane.setBottom(gamePane);
        gamePane.setOnDragDetected(event -> System.out.println("Drag detected gowa el l3ba"));
        Scene scene = new Scene(super.mainPane,1280,720);
        stage.setScene(scene);
        stage.show();
        System.out.println("Arcade");
    }
}


