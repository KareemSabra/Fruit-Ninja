package ViewPackage.GameViewBackgrounds;

import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.ClassicTimer;
import ViewPackage.Menus.PauseScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ClassicScreen {

    Font labelFont = new Font("verdana",16);

    static Label currentScoreLabel = new Label();
    static Label bestScoreLabel = new Label( );;
    static Label livesLabel = new Label();


    public static void setCurrentScoreLabel(String currentScore){
       currentScoreLabel.setText("Score: "+ currentScore);
       setBestScoreLabel(currentScore);
    }
    public static void setBestScoreLabel(String bestScore){
        bestScoreLabel.setText("Score: "+bestScore);
    }
    public static void loseLifeLabel(int livesLeft){
        livesLabel.setText(String.valueOf(livesLeft));
    }

    public HBox classicOverlay(Stage stage)
    {
        VBox scoreBox = new VBox();
        VBox timerLivesBox = new VBox();
        HBox allBox = new HBox();


        currentScoreLabel.setText("Score: 0");
        bestScoreLabel.setText("Best: 0");
        currentScoreLabel.setFont(labelFont);
        currentScoreLabel.setTextFill(Color.WHITE);
        bestScoreLabel.setFont(labelFont);
        bestScoreLabel.setTextFill(Color.WHITE);
        livesLabel.setText("3");
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
                ClassicTimer.getInstance().pauseTimer();
            }
        });


        livesLabel.setFont(labelFont);
        livesLabel.setTextFill(Color.WHITE);
        Label timerLabel;
        timerLabel = ClassicTimer.getInstance().getTimeLabel();
        timerLivesBox.setAlignment(Pos.TOP_RIGHT);
        timerLivesBox.setSpacing(10);
        timerLivesBox.getChildren().addAll(livesLabel,timerLabel);

        allBox.setSpacing(545);
        allBox.getChildren().addAll(scoreBox,pauseButton,timerLivesBox);

        return allBox;

    }
}
