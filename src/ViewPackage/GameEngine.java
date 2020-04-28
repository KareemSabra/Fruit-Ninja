package ViewPackage;

import LogicPackage.GameObject;
import LogicPackage.ImportImage;
import LogicPackage.Instantiation.FruitFactory.FruitFactory;
import LogicPackage.Instantiation.PlayerSingleton;
import MainPackage.MyTimer;
import ViewPackage.Menus.PauseScreen;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameEngine {

    public Node getGame(Stage stage){
        Pane pane = new Pane();
        pane.minWidth(1280);
        pane.minHeight(500);
        int numberFruitsPerWave = (int )(Math.random() * 4 + 1);
        for (int i =0; i<numberFruitsPerWave;i++) {
                GameObject fruit = new FruitFactory().getFruitType();
                Button fruitLabel = new Button(fruit.getObjectType());
                fruitLabel.setLayoutX(fruit.getXlocation());
                fruitLabel.setLayoutY(600);

                fruitLabel.setOnMouseDragEntered(event -> System.out.println("Sliced "));

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
