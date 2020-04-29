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

    Font labelFont = new Font("verdana",16);

    static Label currentScoreLabel = new Label("Score: 0" );
    static Label bestScoreLabel = new Label("Best: 0" );;
    static Label livesLabel = new Label("XXX");

    public static void setCurrentScoreLabel(String currentScore){
       currentScoreLabel.setText("Score: "+currentScore);
       setBestScoreLabel(currentScore);
        System.out.println("Current Score gowa Screen = "+ currentScore);
    }
    public static void setBestScoreLabel(String bestScore){
        bestScoreLabel.setText("Score: "+bestScore);
    }

    public HBox classicOverlay(Stage stage)
    {
        VBox scoreBox = new VBox();
        VBox timerLivesBox = new VBox();
        HBox allBox = new HBox();


        currentScoreLabel.setFont(labelFont);
        currentScoreLabel.setTextFill(Color.WHITE);
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


        livesLabel.setFont(labelFont);
        livesLabel.setTextFill(Color.WHITE);
        Label timerLabel;
        timerLabel = StopWatch.getInstance().getTimeLabel();
        timerLivesBox.setAlignment(Pos.TOP_RIGHT);
        timerLivesBox.setSpacing(10);
        timerLivesBox.getChildren().addAll(livesLabel,timerLabel);

        allBox.setSpacing(545);
        allBox.getChildren().addAll(scoreBox,pauseButton,timerLivesBox);

        return allBox;

    }
}
