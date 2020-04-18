package ViewPackage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClassicScreen extends GameScreen{

    public void prepareScene(Stage stage)
    {
        super.prepareScene(stage);
        Label livesLabel = new Label("X X X");
        livesLabel.setTextFill(Color.WHITE);
        VBox box2 = new VBox(livesLabel);
        box2.setAlignment(Pos.TOP_RIGHT);

        super.mainPane.getChildren().add(box2);
        super.mainPane.getChildren().add(super.pauseButtonBox);

        Scene scene = new Scene(super.mainPane,1280,720);
        stage.setScene(scene);
        stage.show();

    }
}
