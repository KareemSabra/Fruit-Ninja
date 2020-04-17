package ViewPackage;

import MainPackage.ImportImage;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WelcomeScreen {

    public void prepareScene(Stage stage) {

        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1280,720);
        Button newGameButton = new Button();
        Button continueButton = new Button();
        Button settingsButton = new Button("Settings");

        try{
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("MenuBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            stackPane.getChildren().add(backGroundImage);

            BackgroundImage newGameBackgroundImage = new BackgroundImage(new ImportImage().getImage("NewGameButton.png") ,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newGameBackground = new Background(newGameBackgroundImage);
            newGameButton.setBackground(newGameBackground);
            newGameButton.setPrefSize(162,159);

            BackgroundImage continueGameBackgroundImage = new BackgroundImage(new ImportImage().getImage("ContinueGameButton.png") ,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background continueGameBackground = new Background(continueGameBackgroundImage);
            continueButton.setBackground(continueGameBackground);
            continueButton.setPrefSize(162,156);


            RotateTransition rotateTransition = new RotateTransition(Duration.millis(8000),newGameButton);
            rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
            rotateTransition.setByAngle(360);
            rotateTransition.play();

            RotateTransition rotateTransition1 = new RotateTransition(Duration.millis(8000),continueButton);
            rotateTransition1.setCycleCount(RotateTransition.INDEFINITE);
            rotateTransition1.setByAngle(360);
            rotateTransition1.play();

            BackgroundImage newSettingsImage = new BackgroundImage(new ImportImage().getImage("settingsPic.jpg") ,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newSettings = new Background(newSettingsImage);
            settingsButton.setBackground(newSettings);
            settingsButton.setPrefSize(28,32);

        }catch (Exception e){
            System.out.println("Images error");
            newGameButton.setText("New Game");
            continueButton.setText("Continue Game");
        }

        settingsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SettingsScreen.getInstance().getsSettingsScreen();
            }
        });

       newGameButton.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               new GameMode().prepareScene(stage);
           }
       });


        continueButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)  {
                new GameMode().prepareScene(stage);
            }
        });


        HBox settingsBox = new HBox(settingsButton);
        settingsBox.setAlignment(Pos.BOTTOM_RIGHT);

        //Transparent Label to adjust spacing --------------------------------------------------------------------------
        Label transparentLabel = new Label();
        transparentLabel.setPrefWidth(100);
        //--------------------------------------------------------------------------------------------------------------

        HBox buttonsBox = new HBox(50,box2, continueButton, newGameButton,transparentLabel);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        stackPane.getChildren().add(buttonsBox);
        Scene scene = new Scene(stackPane, 1280, 720);


        stage.setMaxWidth(1280);
        stage.setMaxHeight(720);
        stage.setScene(scene);
        stage.show();

    }
}
