package ViewPackage.GameViewBackgrounds;

import LogicPackage.ImportImage;
import MainPackage.MyTimer;
import ViewPackage.GameEngine;
import ViewPackage.Menus.PauseScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public  class GameScreen {
    VBox mainBox = new VBox();
    HBox overlayBox ;
    Stage stage;
    HBox gameBox = new HBox();
    Scene scene ;


    public GameScreen(String mode , Stage stage) {
        if (mode.equalsIgnoreCase("Arcade"))
        {
        overlayBox = new ArcadeScreen().ArcadeOverlay(stage);
        }
        else if (mode.equalsIgnoreCase("Classic"))
        {
            overlayBox = new ClassicScreen().classicOverlay(stage);
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
        gameBox.setMinSize(1280,650);
        gameBox.setOnDragDetected(event -> gameBox.startFullDrag());
        GameEngine gameEngine = new GameEngine();

        /*final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(GameScreen::myTask, 0, 4, TimeUnit.SECONDS);*/

        gameBox.getChildren().add(gameEngine.getGame(stage));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(6), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("6 scs");
                gameBox.getChildren().add(gameEngine.getGame(stage));

            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        timeline.play();

        mainBox.getChildren().add(overlayBox);
        mainBox.getChildren().add(gameBox);
        scene = new Scene(mainBox,1280,720);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ESCAPE))
                {
                    PauseScreen.getInstance().prepareScene(stage);
                    MyTimer.getInstance().pauseTimer();
                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}
