package ViewPackage.GameViewBackgrounds;

import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.StopWatch;
import LogicPackage.PlayerSingleton;
import ViewPackage.GameEngine;
import ViewPackage.Menus.PauseScreen;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public  class GameScreen {
    VBox mainBox = new VBox();
    HBox overlayBox ;
    Stage stage;
    Scene scene ;
    static Timeline timeline;

    public static void pauseTimeline(){
        timeline.pause();
    }
    public static void startTimeline(){
        timeline.playFromStart();
    }
    public static void stopTimeline(){
        timeline.stop();
    }

    public GameScreen(String mode , Stage stage) {
        if (mode.equalsIgnoreCase("Arcade"))
            overlayBox = new ArcadeScreen().ArcadeOverlay(stage);
        else if (mode.equalsIgnoreCase("Classic"))
            overlayBox = new ClassicScreen().classicOverlay(stage);
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

        gameBox.getChildren().add(gameEngine.getGame());

        timeline = new Timeline(new KeyFrame(Duration.seconds(5), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                gameBox.getChildren().clear();
                gameBox.getChildren().add(gameEngine.getGame());
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
                    StopWatch.getInstance().pauseTimer();
                }
            }
        });
        stage.setScene(scene);
        stage.show();
    }
}
