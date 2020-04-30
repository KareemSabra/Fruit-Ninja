package ViewPackage;

import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.ScoreBoard;
import MainPackage.Main;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameOverScreen  {

    public void GameOver(){
        Stage stage = Main.stage;

        StackPane stackPane = new StackPane();
        try{
            BackgroundImage gameBackgroundImage = new BackgroundImage(new ImportImage().getImage("WoodBackground.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background gameBackground = new Background(gameBackgroundImage);
            stackPane.setBackground(gameBackground);
        }catch (Exception e)
        {
            System.out.println("Image Error");
        }

        Label gameOverLabel = new Label("Game Over");
        gameOverLabel.setTextFill(Color.WHITE);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000),gameOverLabel);
        scaleTransition.setByX(3);
        scaleTransition.setByY(3);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), gameOverLabel);
        translateTransition.setByY(-200);
        translateTransition.setAutoReverse(false);

        SequentialTransition sequentialTransition = new SequentialTransition(scaleTransition,translateTransition);
        sequentialTransition.setCycleCount(1);
        sequentialTransition.play();

        stackPane.getChildren().add(gameOverLabel);

        ScoreBoard scoreBoard = new ScoreBoard();
        VBox scoreBox = scoreBoard.getScoreBoard();
        scoreBox.setAlignment(Pos.CENTER);


        Scene scene = new Scene(stackPane,1280,720);
        stage.setScene(scene);
        stage.show();

        sequentialTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stackPane.getChildren().add(scoreBox);
            }
        });
    }
}
