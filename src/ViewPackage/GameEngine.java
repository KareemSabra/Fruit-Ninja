package ViewPackage;

import LogicPackage.GameObject;
import LogicPackage.ImportImage;
import LogicPackage.Instantiation.FruitFactory.FruitFactory;
import LogicPackage.Instantiation.PlayerSingleton;
import MainPackage.MyTimer;
import ViewPackage.Menus.PauseScreen;
import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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

            GameObject fruit = new FruitFactory().getFruitType("pineapple");

            Button fruitLabel = new Button("Pineapple");
            fruitLabel.setLayoutX(fruit.getXlocation());
            fruitLabel.setLayoutY(650);
            fruitLabel.setTranslateX(0);
            fruitLabel.setTranslateY(0);

            fruitLabel.setOnMouseDragEntered(event -> System.out.println("Sliced"));


            TranslateTransition fruitTransitionUP = new TranslateTransition(Duration.millis(2000), fruitLabel);
            fruitTransitionUP.setByY(-fruit.getMaxHeight());
            // fruitTransitionUP.play();


            TranslateTransition fruitTransitionDown = new TranslateTransition(Duration.millis(2000), fruitLabel);
            fruitTransitionDown.setByY(fruit.getMaxHeight() + 50);

            SequentialTransition sequentialTransition = new SequentialTransition(fruitTransitionUP, fruitTransitionDown);
            sequentialTransition.setCycleCount(Animation.INDEFINITE);
            sequentialTransition.play();

            pane.getChildren().add(fruitLabel);





        return pane;
    }
}
