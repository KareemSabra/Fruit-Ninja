package ViewPackage;

import LogicPackage.Instantiation.PlayerSingleton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Difficulties {

    Stage stage;
    Scene scene;
    GameMode gameMode;

    public Difficulties(Stage stage)
    {
        this.stage = stage;
    }

    public void prepareScene()
    {
        Button beginnerDifficulty = new Button("Beginner");
        Button intermediateDifficulty = new Button("Intermediate");
        Button expertDifficulty = new Button("Expert");

        beginnerDifficulty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                playerSingleton.setDifficultyLevel("Easy");
            }
        });

        intermediateDifficulty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                playerSingleton.setDifficultyLevel("Medium");
            }
        });

        expertDifficulty.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                playerSingleton.setDifficultyLevel("Hard");
            }
        });

        HBox box = new HBox(beginnerDifficulty, intermediateDifficulty, expertDifficulty);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(40);
        scene = new Scene(box, 1280,720);


        stage.setScene(scene);
        stage.show();
    }


    public void setGameMode(GameMode gameMode)
    {
        this.gameMode = gameMode;
    }


}
