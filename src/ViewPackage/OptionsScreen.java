package ViewPackage;

import MainPackage.ImportImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class OptionsScreen {

    public void prepareScene(Stage stage)
    {
        Stage optionsStage = new Stage();
        optionsStage.setTitle("Options");

        StackPane pane2 = new StackPane();
        HBox optionsBox = new HBox();
        Button homeButton = new Button();
        Button restartButton = new Button();
        Button resumeButton = new Button();
        optionsBox.setSpacing(20);
        optionsBox.setAlignment(Pos.CENTER);

        optionsBox.getChildren().addAll(homeButton,restartButton,resumeButton);

        try
        {
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("WoodBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            pane2.getChildren().addAll(backGroundImage,optionsBox);

            BackgroundImage newHomeImage = new BackgroundImage(new ImportImage().getImage("homePic.jpg") , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newHome = new Background(newHomeImage);
            homeButton.setBackground(newHome);
            homeButton.setPrefSize(70,70);

            BackgroundImage newRestartImage = new BackgroundImage(new ImportImage().getImage("restartPic.jpg") , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newRestart = new Background(newRestartImage);
            restartButton.setBackground(newRestart);
            restartButton.setPrefSize(70,70);

            BackgroundImage newResumeImage = new BackgroundImage(new ImportImage().getImage("playPic.png") , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newResume = new Background(newResumeImage);
            resumeButton.setBackground(newResume);
            resumeButton.setPrefSize(70,70);
        } catch(Exception e) {
            System.out.println("Error");
        }

        homeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new WelcomeScreen().prepareScene(stage);
                optionsStage.close();

            }
        });

        Scene scene = new Scene(pane2,400,200);
        optionsStage.setScene(scene);
        optionsStage.show();
    }
}
