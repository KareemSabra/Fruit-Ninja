package ViewPackage;

import MainPackage.ImportImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ArcadeScreen extends GameScreen {

    public void prepareScene(Stage stage)
    {
        super.prepareScene(stage);
        Label timerLabel = new Label("1:00");
        timerLabel.setTextFill(Color.WHITE);
        VBox box2 = new VBox(timerLabel);
        box2.setAlignment(Pos.TOP_RIGHT);

        super.mainPane.getChildren().add(box2);

        Scene scene = new Scene(super.mainPane,1280,720);
        stage.setScene(scene);
        stage.show();

    }
}
