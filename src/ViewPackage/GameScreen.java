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

public abstract class GameScreen {
    protected StackPane mainPane;

    // Creating Main Game View------------------------------------------------------------------------------------------
    public void prepareScene() {
        // Initializing Containers -------------------------------------------------------------------------------------
       // StackPane pane = new StackPane();
         mainPane = new StackPane();
        //--------------------------------------------------------------------------------------------------------------
        // Initializing Nodes ------------------------------------------------------------------------------------------
        Label currentScoreLabel = new Label("0");
        currentScoreLabel.setTextFill(Color.WHITE);
        Label bestScoreLabel = new Label("BEST: 0");
        bestScoreLabel.setTextFill(Color.WHITE);
        VBox superBox = new VBox(10,currentScoreLabel, bestScoreLabel);
        superBox.setAlignment(Pos.TOP_LEFT);

        Button pauseButton = new Button();
        //Pause Button Action ------------------------------------------------------------------------------------------
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("OKKK");
            }
        });
        //--------------------------------------------------------------------------------------------------------------


        // Importing needed Images -------------------------------------------------------------------------------------
        try {
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("WoodBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);

            mainPane.getChildren().addAll(backGroundImage);

            BackgroundImage newGameBackgroundImage = new BackgroundImage(new ImportImage().getImage("NewPausePic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newGameBackground = new Background(newGameBackgroundImage);

            pauseButton.setBackground(newGameBackground);
            pauseButton.setPrefSize(32, 27);


        } catch (Exception e) {
            System.out.println("Images not found!");
        }
        //--------------------------------------------------------------------------------------------------------------
        //Pause Button Box----------------------------------------------------------------------------------------------
        VBox pauseButtonBox = new VBox(10,pauseButton);
        pauseButtonBox.setAlignment(Pos.BOTTOM_LEFT);
        mainPane.getChildren().add(pauseButton);
        //--------------------------------------------------------------------------------------------------------------

        mainPane.getChildren().add(superBox);
    }
    //------------------------------------------------------------------------------------------------------------------

}
