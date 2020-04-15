package ViewPackage;

import MainPackage.ImportImage;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        Button continueButton = new Button("Continue last Game");
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
            newGameButton.setPrefSize(500,300);

            RotateTransition rotateTransition = new RotateTransition(Duration.millis(6000),newGameButton);
            rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
            rotateTransition.setByAngle(360);
            rotateTransition.play();
        }catch (Exception e){
            System.out.println("Images error");
            newGameButton.setText("New Game");
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
        HBox box2 = new HBox(settingsButton);
        box2.setAlignment(Pos.BOTTOM_RIGHT);

        HBox buttonsBox = new HBox(box2, continueButton, newGameButton);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        buttonsBox.setSpacing(20);
        stackPane.getChildren().add(buttonsBox);
        Scene scene = new Scene(stackPane, 1280, 720);
        stage.setScene(scene);
        stage.show();

    }
}
