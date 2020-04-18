package ViewPackage.GameViewBackgrounds;

import LogicPackage.ImportImage;
import MainPackage.MyTimer;
import ViewPackage.Menus.PauseScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Timer;

public abstract class GameScreen {
    protected StackPane mainPane;


    Font labelFont = new Font("verdana",22);


    // Creating Main Game View------------------------------------------------------------------------------------------
    public void prepareScene(Stage stage) {
        // Initializing Containers -------------------------------------------------------------------------------------
       // StackPane pane = new StackPane();
         mainPane = new StackPane();
        //--------------------------------------------------------------------------------------------------------------
        // Initializing Nodes ------------------------------------------------------------------------------------------
        Label currentScoreLabel = new Label("0");
        currentScoreLabel.setTextFill(Color.WHITE);
        currentScoreLabel.setFont(labelFont);
        Label bestScoreLabel = new Label("BEST: 0");
        bestScoreLabel.setTextFill(Color.WHITE);
        bestScoreLabel.setFont(labelFont);
        VBox superBox = new VBox(10,currentScoreLabel, bestScoreLabel);
        superBox.setAlignment(Pos.TOP_LEFT);

        // Importing needed Images -------------------------------------------------------------------------------------
        try {
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("WoodBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            mainPane.getChildren().addAll(backGroundImage);

        } catch (Exception e) {
            System.out.println("Images not found!");
        }
        //--------------------------------------------------------------------------------------------------------------

        mainPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode()== KeyCode.ESCAPE){
                     PauseScreen.getInstance().prepareScene(stage);
                    MyTimer.getInstance().pauseTimer();
                }

            }
        });
        mainPane.getChildren().add(superBox);
    }
    //------------------------------------------------------------------------------------------------------------------

}
