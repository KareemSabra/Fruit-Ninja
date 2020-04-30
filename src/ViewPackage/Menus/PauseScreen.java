package ViewPackage.Menus;

import LogicPackage.Commands.HoldGame;
import LogicPackage.Commands.Invoker;
import LogicPackage.Misc.ImportImage;
import LogicPackage.Misc.StopWatch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class PauseScreen {
    private static PauseScreen instance;
    private  Boolean flag = true ;
    private Scene scene = null;
    Stage optionsStage = new Stage();





    public static PauseScreen getInstance(){
        if (instance == null)
            instance = new PauseScreen();
        return instance;
    }
    private PauseScreen() {
    }




    public void prepareScene(Stage stage)
    {
        if(flag) {
            flag = false;

            optionsStage.setTitle("Options");

            StackPane pane2 = new StackPane();
            HBox optionsBox = new HBox();

            Button homeButton = new Button();
            Button restartButton = new Button();
            Button resumeButton = new Button();

            optionsBox.setSpacing(20);
            optionsBox.setAlignment(Pos.CENTER);

            optionsBox.getChildren().addAll(homeButton, restartButton, resumeButton);

            try {
                ImageView backGroundImage = new ImageView(new ImportImage().getImage("WoodBackground.jpg"));
                backGroundImage.setPreserveRatio(true);
                backGroundImage.setFitWidth(1280);
                backGroundImage.setFitHeight(720);
                pane2.getChildren().addAll(backGroundImage, optionsBox);

                BackgroundImage newHomeImage = new BackgroundImage(new ImportImage().getImage("homePic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background newHome = new Background(newHomeImage);
                homeButton.setBackground(newHome);
                homeButton.setPrefSize(70, 70);

                BackgroundImage newRestartImage = new BackgroundImage(new ImportImage().getImage("restartPic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background newRestart = new Background(newRestartImage);
                restartButton.setBackground(newRestart);
                restartButton.setPrefSize(70, 70);

                BackgroundImage newResumeImage = new BackgroundImage(new ImportImage().getImage("playPic.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
                Background newResume = new Background(newResumeImage);
                resumeButton.setBackground(newResume);
                resumeButton.setPrefSize(70, 70);
            } catch (Exception e) {
                System.out.println("Error");
            }

            homeButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Invoker invoker = new Invoker();
                    invoker.setCommands(new HoldGame());
                    invoker.execute();
                    WelcomeScreen.getInstance().prepareScene();
                    optionsStage.close();
                    StopWatch.getInstance().resetTimer();

                }
            });

            scene = new Scene(pane2, 400, 200);
            //Keyboard inputs ----------------------------------------------------------------------------------------------
            //Escape go to main menu----------------------------------------------------------------------------------------
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.ESCAPE) {
                        //TODO: Confirm going back message
                        Invoker invoker = new Invoker();
                        invoker.setCommands(new HoldGame());
                        invoker.execute();
                        StopWatch.getInstance().resetTimer();
                        optionsStage.close();
                    } else if (event.getCode() == KeyCode.ENTER) {
                        optionsStage.close();
                        StopWatch.getInstance().playTimer();
                    }
                }
            });
            //--------------------------------------------------------------------------------------------------------------

        }
        optionsStage.setScene(scene);
        optionsStage.show();
    }
}
