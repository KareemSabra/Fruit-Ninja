package ViewPackage.Menus;


import LogicPackage.Instantiation.GameModeFactory.GameModeFactory;
import LogicPackage.Instantiation.PlayerSingleton;
import MainPackage.ImportImage;
import javafx.animation.RotateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameMode {




    public void prepareScene(Stage stage){
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1280,720);
        Button arcadeButton = new Button();
        Button classicButton = new Button();

        try{
            ImageView backGroundImage = new ImageView(new ImportImage().getImage("MenuBackground.jpg"));
            backGroundImage.setPreserveRatio(true);
            backGroundImage.setFitWidth(1280);
            backGroundImage.setFitHeight(720);
            stackPane.getChildren().add(backGroundImage);

            BackgroundImage ClassicBackgroundImage = new BackgroundImage(new ImportImage().getImage("Classic.png") ,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background classicBackground = new Background(ClassicBackgroundImage);
            classicButton.setBackground(classicBackground);
            classicButton.setPrefSize(162,159);

            RotateTransition rotateTransition = new RotateTransition(Duration.millis(8000), classicButton);
            rotateTransition.setCycleCount(RotateTransition.INDEFINITE);
            rotateTransition.setByAngle(360);
            rotateTransition.play();

            BackgroundImage ArcadeBackgroundImage = new BackgroundImage(new ImportImage().getImage("Arcade.png") ,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background arcadeBackground = new Background(ArcadeBackgroundImage);
            arcadeButton.setBackground(arcadeBackground);
            arcadeButton.setPrefSize(162,159);

            RotateTransition rotateTransition1 = new RotateTransition(Duration.millis(8000), arcadeButton);
            rotateTransition1.setCycleCount(RotateTransition.INDEFINITE);
            rotateTransition1.setByAngle(360);
            rotateTransition1.play();

        }catch (Exception e){
            System.out.println("Images error");
            classicButton.setText("Classic Mode");
            arcadeButton.setText("Arcade Mode");



        }



        classicButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                new GameModeFactory().getMode("Classic",stage);

            }
        });

        arcadeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                PlayerSingleton playerSingleton = PlayerSingleton.getInstance();
                new GameModeFactory().getMode("Arcade",stage);
            }
        });

        Label transparentLabel = new Label();
        transparentLabel.setPrefWidth(100);


        HBox buttonsBox = new HBox();
        buttonsBox.getChildren().addAll(arcadeButton,classicButton,transparentLabel);
        buttonsBox.setSpacing(40);
        buttonsBox.setAlignment(Pos.CENTER_RIGHT);
        stackPane.getChildren().add(buttonsBox);

        Scene scene = new Scene(stackPane,1280,720);

        stage.setScene(scene);
        stage.show();
    }




}