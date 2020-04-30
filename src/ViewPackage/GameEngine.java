package ViewPackage;

import LogicPackage.Commands.EndGame;
import LogicPackage.Commands.Invoker;
import LogicPackage.Commands.LoseLife;
import LogicPackage.DifficutlyController;
import LogicPackage.GameObject;
import LogicPackage.Factories.BombsFactory.BombsFactory;
import LogicPackage.Factories.FruitFactory.FruitFactory;
import LogicPackage.PlayerSingleton;

import ViewPackage.GameViewBackgrounds.ArcadeScreen;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    Boolean bombAnimationDone = false;
    Boolean fruitAnimationDone = false;
    int numberBombsDone = 0;
    int numberFruitsDone = 0;



    int i;

    GameScreen gameScreen ;

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }

    public Node getGame( ){
        Boolean flag = false;
         bombAnimationDone = false;
         fruitAnimationDone = false;
         numberBombsDone = 0;
         numberFruitsDone = 0;

        DifficutlyController difficutlyController = new DifficutlyController();


        Pane pane = new Pane();
        pane.minWidth(1280);
        pane.minHeight(500);
        int numberFruitsPerWave = difficutlyController.getNumberofFruitsWave();

        int numberBombsPerWave = difficutlyController.getNumberofBombsWave();
        if (numberBombsPerWave==0) bombAnimationDone = true;
        int bombLocation ;
        List<Integer> fruitLocationsperwave = new ArrayList<>();


            for ( i = 0; i < numberFruitsPerWave; i++) {


                GameObject fruit = new FruitFactory().getFruitType();
                fruitLocationsperwave.add(fruit.getXlocation());

                Button fruitLabel = new Button();
                fruitLabel.setBackground(fruit.getImages());
                fruitLabel.setPrefSize(230, 250);
                fruitLabel.setLayoutX(fruitLocationsperwave.get(i));
                fruitLabel.setLayoutY(600);

                TranslateTransition fruitTransitionUP = new TranslateTransition(Duration.millis(difficutlyController.getSpeed()), fruitLabel);
                fruitTransitionUP.setByY(-fruit.getMaxHeight());

                TranslateTransition fruitTransitionDown = new TranslateTransition(Duration.millis(difficutlyController.getDownSpeed()), fruitLabel);
                fruitTransitionDown.setByY(fruit.getMaxHeight() + 100);

                RotateTransition rotateTransition = new RotateTransition(Duration.millis(difficutlyController.getSpeed()+difficutlyController.getDownSpeed()), fruitLabel);
                rotateTransition.setByAngle(360);

                SequentialTransition sequentialTransition = new SequentialTransition(fruitTransitionUP, fruitTransitionDown);
                sequentialTransition.setCycleCount(1);

                ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, sequentialTransition);
                parallelTransition.play();


                TranslateTransition fruitFalling = new TranslateTransition(Duration.millis(difficutlyController.getFallingSpeed()), fruitLabel);

                sequentialTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (!fruit.isSliced()){
                            Invoker invoker = new Invoker();
                            invoker.setCommands(new LoseLife());
                            invoker.execute();
                        }
                        numberFruitsDone++;
                        if (numberFruitsDone==numberFruitsPerWave) fruitAnimationDone = true;
                        if (fruitAnimationDone&&bombAnimationDone) gameScreen.getWave();
                    }
                });
                fruitFalling.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberFruitsDone++;
                        if (numberFruitsDone==numberFruitsPerWave) fruitAnimationDone = true;
                        if (fruitAnimationDone&&bombAnimationDone) gameScreen.getWave();
                    }
                });
                fruitLabel.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (!fruit.isSliced()) {
                            fruit.slice();
                            fruitFalling.setByY(fruit.getMaxHeight() + 100);
                            parallelTransition.stop();
                            fruitLabel.setBackground(fruit.getImages());
                            fruitLabel.setPrefSize(230, 250);
                            fruitFalling.play();
                        }
                    }
                });

                fruitLabel.setOnMouseDragEntered(event -> {
                    if (!fruit.isSliced()) {
                        fruit.slice();
                        fruitFalling.setByY(fruit.getMaxHeight() + 100);
                        parallelTransition.stop();
                        fruitLabel.setBackground(fruit.getImages());
                        fruitLabel.setPrefSize(230, 250);
                        fruitFalling.play();
                    }
                });



                pane.getChildren().add(fruitLabel);
            }
            for (int i = 0; i < numberBombsPerWave; i++) {
                GameObject bomb = new BombsFactory().getBombType();
                bombLocation = bomb.getXlocation();
                for (Integer temp :
                        fruitLocationsperwave) {
                    int diff = bombLocation - temp;
                    if (diff < 0) diff *= -1;
                    if ((diff) < 150) {
                        flag = true;
                    }
                }

                Button bombLabel = new Button();
                bombLabel.setBackground(bomb.getImages());
                bombLabel.setPrefSize(230, 250);
                bombLabel.setLayoutX(bombLocation);
                bombLabel.setLayoutY(600);

                bombLabel.setOnMouseDragEntered(event -> {
                    bombLabel.setBackground(bomb.getImages());
                    bombLabel.setPrefSize(230, 250);
                    try {bomb.slice();}
                    catch (Exception e){
                        System.out.println("Illegal bomb red");
                        Invoker invoker = new Invoker();
                        invoker.setCommands(new EndGame());
                        invoker.execute();
                    }
                });

                TranslateTransition bombTransitionUp = new TranslateTransition(Duration.millis(2000), bombLabel);
                bombTransitionUp.setByY(-bomb.getMaxHeight());

                TranslateTransition bombTransitionDown = new TranslateTransition(Duration.millis(2000), bombLabel);
                bombTransitionDown.setByY(bomb.getMaxHeight() + 100);

                RotateTransition rotateTransition = new RotateTransition(Duration.millis(4000), bombLabel);
                rotateTransition.setByAngle(360);

                SequentialTransition sequentialTransition = new SequentialTransition(bombTransitionUp, bombTransitionDown);
                sequentialTransition.setCycleCount(1);

                sequentialTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        numberBombsDone++;
                        if (numberBombsDone==numberBombsPerWave) bombAnimationDone = true;
                        if (bombAnimationDone && fruitAnimationDone) gameScreen.getWave();

                    }
                });
                

                ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, sequentialTransition);
                parallelTransition.play();

                if (!flag)
                    pane.getChildren().add(bombLabel);
            }
        return pane;
    }
}
