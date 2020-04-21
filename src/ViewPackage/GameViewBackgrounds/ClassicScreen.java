package ViewPackage.GameViewBackgrounds;

import ViewPackage.GameEngine;
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
        livesLabel.setAlignment(Pos.TOP_RIGHT);
        VBox box2 = new VBox(livesLabel);
        box2.setAlignment(Pos.TOP_RIGHT);
        super.topView.getChildren().add(box2);
        StackPane gamePane = new StackPane();
        GameEngine gameEngine = new GameEngine();
        gamePane.getChildren().add(gameEngine.getGame(stage));
        super.mainPane.setBottom(gamePane);
        Scene scene = new Scene(super.mainPane,1280,720);
        stage.setScene(scene);
        stage.show();

    }
}
