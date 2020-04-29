package ViewPackage;

import LogicPackage.GameObject;
import LogicPackage.Instantiation.FruitFactory.FruitFactory;
import LogicPackage.Instantiation.PlayerSingleton;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameEngine {

    Font labelFont = new Font("verdana",24);
    int slice = 0;

    public Node getGame(Stage stage){
        Pane pane = new Pane();
        pane.minWidth(1280);
        pane.minHeight(500);
        Label currentScoreLabel = new Label("Score: " + String.valueOf(PlayerSingleton.getCurrentScore()));
        currentScoreLabel.setFont(labelFont);
        currentScoreLabel.setTextFill(Color.WHITE);
        int numberFruitsPerWave = (int )(Math.random() * 4 + 1);

        for (int i =0; i<numberFruitsPerWave;i++) {

            slice =0;
                GameObject fruit = new FruitFactory().getFruitType();
                Button fruitLabel = new Button();
                fruitLabel.setBackground(fruit.getImages());
                fruitLabel.setPrefSize(230, 250);
                fruitLabel.setLayoutX(fruit.getXlocation());
                fruitLabel.setLayoutY(600);


                fruitLabel.setOnMouseDragEntered(event -> {
                    if (fruit.isSliced() == false) {
                        PlayerSingleton.calculateCurrentScore();
                        PlayerSingleton.calculateBestScore();
                        currentScoreLabel.setText("Score: " + String.valueOf(PlayerSingleton.getCurrentScore()));
                    }
                    fruit.slice();
                    fruitLabel.setBackground(fruit.getImages());
                    slice = 1;
                    fruitLabel.setPrefSize(230, 250);
                    //System.out.println(GameLogic.getCurrentScore());
                });



                TranslateTransition fruitTransitionUP = new TranslateTransition(Duration.millis(2000), fruitLabel);
                fruitTransitionUP.setByY(-fruit.getMaxHeight());

                TranslateTransition fruitTransitionDown = new TranslateTransition(Duration.millis(2000), fruitLabel);
                fruitTransitionDown.setByY(fruit.getMaxHeight() + 50);

                RotateTransition rotateTransition = new RotateTransition(Duration.millis(4000),fruitLabel);
                rotateTransition.setByAngle(360);

                SequentialTransition sequentialTransition = new SequentialTransition(fruitTransitionUP, fruitTransitionDown);
                sequentialTransition.setCycleCount(1);

                ParallelTransition parallelTransition = new ParallelTransition(rotateTransition,sequentialTransition);
                parallelTransition.play();

                pane.getChildren().add(fruitLabel);

            }
        pane.getChildren().add(currentScoreLabel);
        return pane;
    }
}
