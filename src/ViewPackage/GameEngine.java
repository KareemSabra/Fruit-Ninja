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
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;

public class GameEngine {

    ArrayList<GameObject> fruitsArray = new ArrayList<>();



    public Node getGame(Stage stage){
        Pane pane = new Pane();
        pane.minWidth(1250);
        pane.minHeight(500);

            GameObject pineApple = new FruitFactory().getFruitType("pineapple");
            fruitsArray.add(pineApple);
            GameObject watermelon = new FruitFactory().getFruitType("watermelon");
            fruitsArray.add(watermelon);

        Image watermelonSliced = new ImportImage().getImage("WatermelonSliced (1).png");

        Image pineappleSliced = new ImportImage().getImage("PineappleSliced (1).png");

        Image watermelonImage = new ImportImage().getImage("Watermelon (1).png");

        Image pineappleImage = new ImportImage().getImage("Pineapple (1).png");

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(1);
        rectangle.setWidth(500);
        rectangle.setY(400);
        rectangle.setFill(Color.TRANSPARENT);
        pane.getChildren().add(rectangle);

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setHeight(1);
        rectangle1.setWidth(500);
        rectangle1.setY(1450);
        rectangle1.setFill(Color.TRANSPARENT);
        pane.getChildren().add(rectangle1);

        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(100),
                        (evt) -> {

                            for(int i=0; i<=fruitsArray.size()-1;i++)
                            {
                                fruitsArray.get(i).getFruitImages().setY(fruitsArray.get(i).getFruitImages().getY() - fruitsArray.get(i).getInitialVelocity());
                            }

                            for(int i =0;i<=fruitsArray.size()-1;i++) {
                                if (fruitsArray.get(i).getFruitImages().getBoundsInLocal().intersects(rectangle.getBoundsInLocal())) {

                                    fruitsArray.get(i).getFruitImages().setY(fruitsArray.get(i).getFruitImages().getY() + fruitsArray.get(i).getFallingVelocity());
                                }
                            }


                                if ((fruitsArray.get(0).getFruitImages().getBoundsInLocal().intersects(rectangle1.getBoundsInLocal()))) {


                                    if (fruitsArray.get(0).getFruitImages().getImage().equals(watermelonSliced)) {
                                        fruitsArray.get(0).getFruitImages().setImage(pineappleImage);
                                    }

                                    fruitsArray.get(1).getFruitImages().setY(fruitsArray.get(1).getFruitImages().getY() + fruitsArray.get(1).getInitialVelocity());
                                }

                            if ((fruitsArray.get(1).getFruitImages().getBoundsInLocal().intersects(rectangle1.getBoundsInLocal()))) {


                                if (fruitsArray.get(1).getFruitImages().getImage().equals(pineappleSliced)) {
                                    fruitsArray.get(1).getFruitImages().setImage(watermelonImage);
                                }

                                fruitsArray.get(0).getFruitImages().setY(fruitsArray.get(0).getFruitImages().getY() + fruitsArray.get(0).getInitialVelocity());
                            }

                            pane.setOnDragDetected(e -> pane.startFullDrag());


                            fruitsArray.get(0).getFruitImages().setOnMouseDragEntered(evt2 -> {


                                if(fruitsArray.get(0).getFruitImages().getImage().equals(watermelonImage)) {
                                    fruitsArray.get(0).getFruitImages().setImage(watermelonSliced);
                                }
                                else if(fruitsArray.get(0).getFruitImages().getImage().equals(pineappleImage)) {
                                    fruitsArray.get(0).getFruitImages().setImage(pineappleSliced);
                                }

                            });

                            fruitsArray.get(1).getFruitImages().setOnMouseDragEntered(evt2 -> {


                                if(fruitsArray.get(1).getFruitImages().getImage().equals(watermelonImage)) {
                                    fruitsArray.get(1).getFruitImages().setImage(watermelonSliced);
                                }
                                else if(fruitsArray.get(1).getFruitImages().getImage().equals(pineappleImage)) {
                                    fruitsArray.get(1).getFruitImages().setImage(pineappleSliced);
                                }

                            });

                        }));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.setAutoReverse(true);
        timeline.play();

        return pane;
    }
}
