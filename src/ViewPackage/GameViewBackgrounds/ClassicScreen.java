package ViewPackage.GameViewBackgrounds;

import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.StopWatch;
import LogicPackage.PlayerSingleton;
import ViewPackage.Menus.PauseScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClassicScreen {

    Font labelFont = new Font("verdana",24);

    static Label currentScoreLabel;
    static Label bestScoreLabel;
    static Label livesLabel;

    public static Label getLivesLabel() {
        return livesLabel;
    }

    public static Label getCurrentScoreLabel() {
        return currentScoreLabel;
    }

    public static Label getBestScoreLabel() {
        return bestScoreLabel;
    }

    public HBox classicOverlay(Stage stage)
    {
        VBox scoreBox = new VBox();
        VBox timerLivesBox = new VBox();
        HBox allBox = new HBox();


        Label currentScoreLabel = new Label("Score:");
        Label bestScoreLabel = new Label("Best:");

        currentScoreLabel = new Label("Score: " + String.valueOf(PlayerSingleton.getCurrentScore()));
        currentScoreLabel.setFont(labelFont);
        currentScoreLabel.setTextFill(Color.WHITE);
        bestScoreLabel = new Label("Best: " + String.valueOf(PlayerSingleton.getBestScore()));
        bestScoreLabel.setFont(labelFont);
        bestScoreLabel.setTextFill(Color.WHITE);
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
                StopWatch.getInstance().pauseTimer();
            }
        });

        Label livesLabel = new Label("XXX");
        livesLabel = new Label("XXX");
        livesLabel.setFont(labelFont);
        livesLabel.setTextFill(Color.WHITE);
        Label timerLabel = new Label();
        timerLabel = StopWatch.getInstance().getTimeLabel();
        timerLivesBox.setAlignment(Pos.TOP_RIGHT);
        timerLivesBox.setSpacing(10);
        timerLivesBox.getChildren().addAll(livesLabel,timerLabel);

        allBox.setSpacing(575);
        allBox.getChildren().addAll(scoreBox,pauseButton,timerLivesBox);

        return allBox;

    }
}
