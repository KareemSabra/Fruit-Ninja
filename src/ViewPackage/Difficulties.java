package ViewPackage;

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
        Button begin = new Button("Beginner");
        Button inter = new Button("Intermediate");
        Button expert = new Button("Expert");

        HBox box = new HBox(begin, inter, expert);
        box.setAlignment(Pos.CENTER);
        box.setSpacing(40);
        scene = new Scene(box, 1280,720);

        stage.setScene(scene);
        stage.show();
    }

    public Scene getScene()
    {
        return scene;
    }

    public void setGameMode(GameMode gameMode)
    {
        this.gameMode = gameMode;
    }


}
