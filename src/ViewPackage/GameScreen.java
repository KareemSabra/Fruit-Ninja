package ViewPackage;

import MainPackage.ImportImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class GameScreen {
    // Creating Main Game View------------------------------------------------------------------------------------------
    public void prepareScene(Stage stage) {
        // Initializing Containers -------------------------------------------------------------------------------------
        StackPane pane = new StackPane();
        StackPane pane2 = new StackPane();
        //--------------------------------------------------------------------------------------------------------------
        // Initializing Nodes ------------------------------------------------------------------------------------------
        Label currentScoreLabel = new Label("0");
        currentScoreLabel.setTextFill(Color.WHITE);
        Label bestScoreLabel = new Label("BEST: 0");
        bestScoreLabel.setTextFill(Color.WHITE);

        Button pauseButton = new Button();

        VBox superBox = new VBox(10,currentScoreLabel, bestScoreLabel);
        superBox.setAlignment(Pos.TOP_LEFT);

        // Importing needed Images -------------------------------------------------------------------------------------
        try {
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("WoodBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            pane2.getChildren().addAll(backGroundImage, pane);
            BackgroundImage newGameBackgroundImage = new BackgroundImage(new ImportImage().getImage("NewPausePic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newGameBackground = new Background(newGameBackgroundImage);
            pauseButton.setBackground(newGameBackground);
            pauseButton.setPrefSize(32, 27);
        } catch (Exception e) {
            System.out.println("Error");
        }
        //--------------------------------------------------------------------------------------------------------------
        //Pause Button Action ------------------------------------------------------------------------------------------
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new OptionsScreen().prepareScene(stage);
            }
        });
        //--------------------------------------------------------------------------------------------------------------
    }
    //------------------------------------------------------------------------------------------------------------------

}
