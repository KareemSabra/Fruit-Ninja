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

public class ClassicScreen extends GameScreen{

    public void prepareScene(Stage stage)
    {
        super.prepareScene();
        Label livesLabel = new Label("X X X");
        livesLabel.setTextFill(Color.WHITE);
        VBox box2 = new VBox(livesLabel);
        box2.setAlignment(Pos.TOP_RIGHT);

        Scene scene = new Scene(box2,1280,720);
        stage.setScene(scene);
        stage.show();

    }
}
