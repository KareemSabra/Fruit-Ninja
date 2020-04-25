package ViewPackage.GameViewBackgrounds;

import LogicPackage.ImportImage;
import MainPackage.MyTimer;
import ViewPackage.GameEngine;
import ViewPackage.Menus.PauseScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public  class GameScreen {
    VBox mainBox = new VBox();
    HBox overlayBox ;
    Stage stage;

    public GameScreen(String mode , Stage stage) {
        if (mode.equalsIgnoreCase("Arcade"))
        {
        overlayBox = new ArcadeScreen().ArcadeOverlay();
        }
        else if (mode.equalsIgnoreCase("Classic"))
        {
            overlayBox = new ClassicScreen().classicOverlay();
        }
        this.stage = stage;
        prepareScreen();
    }

    public void prepareScreen(){
        mainBox.setPrefSize(1280,720);
        try{
            BackgroundImage gameBackgroundImage = new BackgroundImage(new ImportImage().getImage("WoodBackground.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background gameBackground = new Background(gameBackgroundImage);
            mainBox.setBackground(gameBackground);
        }catch (Exception e)
        {
            System.out.println("Image Error");
        }


        HBox gameBox = new HBox();
        gameBox.setPrefSize(1280,650);
        gameBox.getChildren().add(new  GameEngine().getGame(stage));


        mainBox.getChildren().addAll(overlayBox,gameBox);
        Scene scene = new Scene(mainBox,1280,720);
        stage.setScene(scene);
        stage.show();
    }
}
