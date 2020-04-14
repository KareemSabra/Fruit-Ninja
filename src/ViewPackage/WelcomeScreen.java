package ViewPackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeScreen {

    Stage stage;
    Scene scene;


    public WelcomeScreen(Stage stage)
    {
        this.stage = stage;
    }



    public void prepareScene() {
        Label title = new Label("Fruit Ninja");
        Button newGame = new Button("New game");
        Button cont = new Button("Continue");

        newGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GameMode gameMode = new GameMode(stage);
                gameMode.prepareScene();
                stage.setScene(gameMode.getScene());
            }
        });

        HBox box1 = new HBox(cont, newGame);
        box1.setAlignment(Pos.CENTER);
        box1.setSpacing(20);
        VBox box = new VBox(title, box1);
        box.setSpacing(40);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }


    public Scene getScene()
    {
        return scene;
    }




}
