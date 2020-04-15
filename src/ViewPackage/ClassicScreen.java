package ViewPackage;

import MainPackage.ImportImage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClassicScreen {

    public void prepareScene(Stage stage)
    {
        StackPane pane = new StackPane();
        StackPane pane2 = new StackPane();
        Label currentScoreLabel = new Label("0");
        currentScoreLabel.setTextFill(Color.WHITE);
        Label bestScoreLabel = new Label("BEST: 0");
        bestScoreLabel.setTextFill(Color.WHITE);
        Label livesLabel = new Label("X X X");
        livesLabel.setTextFill(Color.WHITE);
        Button pauseButton = new Button();
        VBox box = new VBox(currentScoreLabel, bestScoreLabel);
        box.setAlignment(Pos.TOP_LEFT);
        box.setSpacing(10);
        VBox box2 = new VBox(livesLabel);
        box2.setAlignment(Pos.TOP_RIGHT);


        try {
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("WoodBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            pane2.getChildren().addAll(backGroundImage,pane);
            BackgroundImage newGameBackgroundImage = new BackgroundImage(new ImportImage().getImage("NewPausePic.jpg") , BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background newGameBackground = new Background(newGameBackgroundImage);
            pauseButton.setBackground(newGameBackground);
            pauseButton.setPrefSize(32,27);
        } catch(Exception e){
            System.out.println("Error");
        }

        VBox box3 = new VBox(pauseButton);
        box3.setAlignment(Pos.BOTTOM_LEFT);
        pane.getChildren().addAll(box,box2,box3);
        Scene scene = new Scene(pane2,1280,720);
        stage.setScene(scene);
        stage.show();

    }
}
