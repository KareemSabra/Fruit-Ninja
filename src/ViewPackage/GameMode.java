package ViewPackage;


import LogicPackage.Instantiation.PlayerSingleton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class GameMode {

    public void prepareScene(Stage stage){

        Button arcade = new Button("Arcade");
        Button classic = new Button("Classic");

        arcade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                playerSingleton.setGameMode("Arcade");
                Difficulties diff = new Difficulties();
                diff.prepareScene(stage);
            }
        });
        classic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                playerSingleton.setGameMode("Classic");
                Difficulties diff = new Difficulties();
                diff.prepareScene(stage);
            }
        });

        HBox box = new HBox();
        box.getChildren().addAll(arcade,classic);
        box.setSpacing(40);
        box.setAlignment(Pos.CENTER);

        Scene scene = new Scene(box,1280,720);

        stage.setScene(scene);
        stage.show();
    }
}