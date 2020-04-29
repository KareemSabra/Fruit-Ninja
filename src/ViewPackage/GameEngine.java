package ViewPackage;

import LogicPackage.GameObject;
import LogicPackage.Factories.BombsFactory.BombsFactory;
import LogicPackage.Factories.FruitFactory.FruitFactory;
import LogicPackage.PlayerSingleton;
import ViewPackage.GameViewBackgrounds.ArcadeScreen;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    Font labelFont = new Font("verdana", 24);
    int slicedFruit = 0;
    int numberOfFruits = 0;

    public Node getGame() {
        Pane pane = new Pane();
        pane.minWidth(1280);
        pane.minHeight(500);
        int numberFruitsPerWave = (int) (Math.random() * 4 + 1);
        int numberBombsPerWave = (int) (Math.random() * 2);
        List<Integer> fruitLocationsperwave = new ArrayList<>();
        Integer bombLocation;
        Boolean flag = false;
        Integer i;

        for (i = 0; i < numberFruitsPerWave; i++) {

            numberOfFruits = numberOfFruits + numberFruitsPerWave;
            System.out.println("fruits = " + numberOfFruits);
            System.out.println("wave = " + numberFruitsPerWave);


            for (i = 0; i < numberFruitsPerWave; i++) {

                GameObject fruit = new FruitFactory().getFruitType();
                fruitLocationsperwave.add(fruit.getXlocation());

                Button fruitLabel = new Button();
                fruitLabel.setBackground(fruit.getImages());
                fruitLabel.setPrefSize(230, 250);
                fruitLabel.setLayoutX(fruitLocationsperwave.get(i));
                fruitLabel.setLayoutY(600);

                fruitLabel.setOnMouseDragEntered(event -> {
                    System.out.println("Sliced");

                    if (fruit.isSliced() == false) {
                        PlayerSingleton.calculateCurrentScore();
                        PlayerSingleton.calculateBestScore();
                        ClassicScreen.getCurrentScoreLabel().setText("Score: " + String.valueOf(PlayerSingleton.getCurrentScore()));
                        ClassicScreen.getBestScoreLabel().setText("Best: " + String.valueOf(PlayerSingleton.getBestScore()));
                        slicedFruit++;
                    }
                    fruit.slice();
                    System.out.println("sliced = " + slicedFruit);
                    fruitLabel.setBackground(fruit.getImages());
                    fruitLabel.setPrefSize(230, 250);
                });

                TranslateTransition fruitTransitionUP = new TranslateTransition(Duration.millis(2000), fruitLabel);
                fruitTransitionUP.setByY(-fruit.getMaxHeight());

                TranslateTransition fruitTransitionDown = new TranslateTransition(Duration.millis(2000), fruitLabel);
                fruitTransitionDown.setByY(fruit.getMaxHeight() + 100);

                RotateTransition rotateTransition = new RotateTransition(Duration.millis(4000), fruitLabel);
                rotateTransition.setByAngle(360);

                SequentialTransition sequentialTransition = new SequentialTransition(fruitTransitionUP, fruitTransitionDown);
                sequentialTransition.setCycleCount(1);

                ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, sequentialTransition);
                parallelTransition.play();

                pane.getChildren().add(fruitLabel);
            }
            for (i = 0; i < numberBombsPerWave; i++) {
                GameObject bomb = new BombsFactory().getBombType();
                bombLocation = bomb.getXlocation();
                for (Integer temp :
                        fruitLocationsperwave) {
                    int diff = bombLocation - temp;
                    if (diff < 0) diff *= -1;
                    if ((diff) < 150) {
                        System.out.println("Orayeben");
                        flag = true;
                    }
                }

                Button bombLabel = new Button();
                bombLabel.setBackground(bomb.getImages());
                bombLabel.setPrefSize(230, 250);
                bombLabel.setLayoutX(bombLocation);
                bombLabel.setLayoutY(600);

                bombLabel.setOnMouseDragExited(event -> {
                    System.out.println("Sliced");
                    bomb.slice();
                    bombLabel.setBackground(bomb.getImages());
                    bombLabel.setPrefSize(230, 250);
                });

                TranslateTransition bombTransitionUp = new TranslateTransition(Duration.millis(2000), bombLabel);
                bombTransitionUp.setByY(-bomb.getMaxHeight());

                TranslateTransition bombTransitionDown = new TranslateTransition(Duration.millis(2000), bombLabel);
                bombTransitionDown.setByY(bomb.getMaxHeight() + 100);

                RotateTransition rotateTransition = new RotateTransition(Duration.millis(4000), bombLabel);
                rotateTransition.setByAngle(360);

                SequentialTransition sequentialTransition = new SequentialTransition(bombTransitionUp, bombTransitionDown);
                sequentialTransition.setCycleCount(1);

                ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, sequentialTransition);
                parallelTransition.play();

                if (!flag)
                    pane.getChildren().add(bombLabel);
            }

        }
        return pane;
    }
}
