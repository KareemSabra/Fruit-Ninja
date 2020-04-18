package ViewPackage;

import LogicPackage.ImportImage;
import MainPackage.MyTimer;
import ViewPackage.Menus.PauseScreen;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameEngine {
    Timeline arcadeTimeline;

    public void setArcadeTimeline(Timeline arcadeTimeline) {
        this.arcadeTimeline = arcadeTimeline;
    }

    public Node getGame(Stage stage){
        Group group = new Group();


        //Pause Button -------------------------------------------------------------------------------------------------
        Button pauseButton = new Button();
        try{
            BackgroundImage pauseButtonIconImage = new BackgroundImage(new ImportImage().getImage("NewPausePic.jpg"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
            Background pauseButtonIcon = new Background(pauseButtonIconImage);

            pauseButton.setBackground(pauseButtonIcon);
            pauseButton.setPrefSize(32, 27);
        }catch(Exception e)
        {
            System.out.println("Pause Button Icon cannot be found !");
        }
        HBox engineBox = new HBox(10,pauseButton,group);
        engineBox.setAlignment(Pos.BOTTOM_LEFT);
        pauseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                PauseScreen.getInstance().prepareScene(stage);
                MyTimer.getInstance().pauseTimer();

            }
        });
        //--------------------------------------------------------------------------------------------------------------

        return engineBox;
    }
}
