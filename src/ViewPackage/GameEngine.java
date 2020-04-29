package ViewPackage;

import LogicPackage.GameObject;
import LogicPackage.Instantiation.FruitFactory.FruitFactory;
import LogicPackage.Instantiation.PlayerSingleton;
import ViewPackage.GameViewBackgrounds.ArcadeScreen;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
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
    int slicedFruit =0;
    int numberOfFruits =0;

    public Node getGame(Stage stage){
        Pane pane = new Pane();
        pane.minWidth(1280);
        pane.minHeight(500);
        int numberFruitsPerWave = (int )(Math.random() * 4 + 1);
        numberOfFruits = numberOfFruits + numberFruitsPerWave;
        int numberBombsPerWave = (int) (Math.random() * 2);

        System.out.println("fruits = " +numberOfFruits);
        System.out.println("wave = " + numberFruitsPerWave);


        for (int i =0; i<numberFruitsPerWave;i++) {

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
                        ClassicScreen.getCurrentScoreLabel().setText("Score: " + String.valueOf(PlayerSingleton.getCurrentScore()));
                        ClassicScreen.getBestScoreLabel().setText("Best: " + String.valueOf(PlayerSingleton.getBestScore()));
                        slicedFruit ++;
                    }
                    fruit.slice();
                    System.out.println("sliced = " + slicedFruit);
                    fruitLabel.setBackground(fruit.getImages());
                    fruitLabel.setPrefSize(230, 250);
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
        return pane;
    }
}
