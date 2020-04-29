package ViewPackage;

import LogicPackage.GameObject;
import LogicPackage.Factories.BombsFactory.BombsFactory;
import LogicPackage.Factories.FruitFactory.FruitFactory;
import javafx.animation.*;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

import javafx.util.Duration;

public class GameEngine {

    public Node getGame(){
        Pane pane = new Pane();
        pane.minWidth(1280);
        pane.minHeight(500);
        int numberFruitsPerWave = (int )(Math.random() * 4 + 1);
        int numberBombsPerWave = (int) (Math.random()*2);

        for (int i =0; i<numberFruitsPerWave;i++) {
                GameObject fruit = new FruitFactory().getFruitType();
                Button fruitLabel = new Button();
                fruitLabel.setBackground(fruit.getImages());
                fruitLabel.setPrefSize(230, 250);
                fruitLabel.setLayoutX(fruit.getXlocation());
                fruitLabel.setLayoutY(600);

                fruitLabel.setOnMouseDragEntered(event -> {
                    System.out.println("Sliced");
                    fruit.slice();
                    fruitLabel.setBackground(fruit.getImages());
                    fruitLabel.setPrefSize(230, 250);
                });

                TranslateTransition fruitTransitionUP = new TranslateTransition(Duration.millis(2000),fruitLabel);
                fruitTransitionUP.setByY(-fruit.getMaxHeight());

                TranslateTransition fruitTransitionDown = new TranslateTransition(Duration.millis(2000),fruitLabel);
                fruitTransitionDown.setByY(fruit.getMaxHeight() + 100);

                RotateTransition rotateTransition = new RotateTransition(Duration.millis(4000),fruitLabel);
                rotateTransition.setByAngle(360);

                SequentialTransition sequentialTransition = new SequentialTransition(fruitTransitionUP,fruitTransitionDown);
                sequentialTransition.setCycleCount(1);

                ParallelTransition parallelTransition = new ParallelTransition(rotateTransition,sequentialTransition);
                parallelTransition.play();

                pane.getChildren().add(fruitLabel);
            }
        for (int i=0 ; i<numberBombsPerWave;i++){
            GameObject bomb = new BombsFactory().getBombType();

            Button bombLabel = new Button();
            bombLabel.setBackground(bomb.getImages());
            bombLabel.setPrefSize(230, 250);
            bombLabel.setLayoutX(bomb.getXlocation());
            bombLabel.setLayoutY(600);

            bombLabel.setOnMouseDragExited(event -> {
                System.out.println("Sliced");
                bomb.slice();
                bombLabel.setBackground(bomb.getImages());
                bombLabel.setPrefSize(230, 250);
            });

            TranslateTransition bombTransitionUp = new TranslateTransition(Duration.millis(2000),bombLabel);
            bombTransitionUp.setByY(-bomb.getMaxHeight());

            TranslateTransition bombTransitionDown = new TranslateTransition(Duration.millis(2000),bombLabel);
            bombTransitionDown.setByY(bomb.getMaxHeight() + 100);

            RotateTransition rotateTransition = new RotateTransition(Duration.millis(4000),bombLabel);
            rotateTransition.setByAngle(360);

            SequentialTransition sequentialTransition = new SequentialTransition(bombTransitionUp,bombTransitionDown);
            sequentialTransition.setCycleCount(1);

            ParallelTransition parallelTransition = new ParallelTransition(rotateTransition,sequentialTransition);
            parallelTransition.play();

            pane.getChildren().add(bombLabel);
        }

        return pane;
    }
}
