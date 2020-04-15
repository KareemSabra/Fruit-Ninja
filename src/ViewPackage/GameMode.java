package ViewPackage;


import LogicPackage.Instantiation.PlayerSingleton;
import MainPackage.ImportImage;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameMode {




    public void prepareScene(Stage stage){
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1280,720);

        try{
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("MenuBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            stackPane.getChildren().add(backGroundImage);

        }catch (Exception e){
            System.out.println("Images error");
        }

        Button arcade = new Button("Arcade");
        Button classic = new Button("Classic");

        classic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                playerSingleton.setGameMode("Classic");
                ClassicScreen classicScreen = new ClassicScreen();
                classicScreen.prepareScene(stage);

            }
        });

        arcade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                playerSingleton.setGameMode("Arcade");
                ArcadeScreen arcadeScreen = new ArcadeScreen();
                arcadeScreen.prepareScene(stage);
            }
        });

        HBox buttonsBox = new HBox();
        buttonsBox.getChildren().addAll(arcade,classic);
        buttonsBox.setSpacing(40);
        buttonsBox.setAlignment(Pos.CENTER);
        stackPane.getChildren().add(buttonsBox);

        Scene scene = new Scene(stackPane,1280,720);

        stage.setScene(scene);
        stage.show();
    }




}