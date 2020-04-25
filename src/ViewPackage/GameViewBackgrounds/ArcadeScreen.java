package ViewPackage.GameViewBackgrounds;

import LogicPackage.ImportImage;
import MainPackage.MyTimer;
import ViewPackage.GameEngine;
import ViewPackage.Menus.PauseScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class ArcadeScreen  {

    public HBox ArcadeOverlay(Stage stage)
    {
        VBox scoreBox = new VBox();
        HBox allBox = new HBox();

        Label currentScoreLabel = new Label("Score:");
        Label bestScoreLabel = new Label("Best:");
        scoreBox.setSpacing(10);
        scoreBox.setAlignment(Pos.TOP_LEFT);
        scoreBox.getChildren().addAll(currentScoreLabel,bestScoreLabel);

        Button pauseButton = new Button();

        try{
            BackgroundImage newPausePic = new BackgroundImage(new ImportImage().getImage("NewPausePic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newPause = new Background(newPausePic);
            pauseButton.setBackground(newPause);
            pauseButton.setPrefSize(28, 32);
        }catch(Exception e){
            pauseButton.setText("Pause");
        }

        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PauseScreen.getInstance().prepareScene(stage);
            }
        });

        Label timerLabel = new Label();

        allBox.setSpacing(575);
        allBox.getChildren().addAll(scoreBox,pauseButton,timerLabel);

        return allBox;

    }
}


