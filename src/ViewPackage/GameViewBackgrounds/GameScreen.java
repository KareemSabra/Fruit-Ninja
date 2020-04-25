package ViewPackage.GameViewBackgrounds;

import LogicPackage.ImportImage;
import MainPackage.MyTimer;
import ViewPackage.Menus.PauseScreen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Timer;

public  class GameScreen {
    VBox mainBox = new VBox();
    HBox overlayBox ;
    Stage stage;

    public GameScreen(String mode , Stage stage) {
        if (mode.equalsIgnoreCase("Arcade"))
        {
        overlayBox = new ArcadeScreen().ArcadeOverlay();
        }
        else if (mode.equalsIgnoreCase("Classic"))
        {
            overlayBox = new ClassicScreen().classicOverlay();
        }
        this.stage = stage;
        prepareScreen();
    }

    public void prepareScreen(){
        System.out.println("Working");

    }


}
