package ViewPackage;

import LogicPackage.Instantiation.PlayerSingleton;
import MainPackage.ImportImage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Difficulties {

    public void prepareScene(Stage stage)
    {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1280,720);

        try{
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("MenuBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            stackPane.getChildren().add(backGroundImage);

        }catch (Exception e){
            System.out.println("Images error");
        }

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

        HBox buttonsBox = new HBox(beginnerDifficulty, intermediateDifficulty, expertDifficulty);
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(40);
        stackPane.getChildren().add(buttonsBox);
        Scene scene = new Scene(stackPane, 1280,720);
        stage.setScene(scene);
        stage.show();
    }





}
