package ViewPackage;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class GameMode {

    Stage stage;
    Scene scene;
    WelcomeScreen welcome;
    Difficulties diff;
    public GameMode (Stage stage){
        this.stage = stage;
    }

    public void prepareScene(){

        Button arcade = new Button("Arcade");
        Button classic = new Button("Classic");

        arcade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                diff.prepareScene();
                stage.setScene(diff.getScene());
            }
        });

        classic.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                diff.prepareScene();
                stage.setScene(diff.getScene());
            }
        });

        HBox box = new HBox();
        box.getChildren().addAll(arcade,classic);
        box.setSpacing(40);
        box.setAlignment(Pos.CENTER);

        scene = new Scene(box,1280,720);

        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene()
    {
        return scene;
    }
    public void setWelcomeScreen(WelcomeScreen welcome)
    {
        this.welcome = welcome;
    }
    public void setDifficulties(Difficulties diff)
    {
        this.diff = diff;
    }

}