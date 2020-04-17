package LogicPackage.Instantiation.GameModeFactory;

import ViewPackage.ArcadeScreen;
import ViewPackage.GameScreen;
import javafx.stage.Stage;

public class Arcade implements Mode {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void gameMode()
    {
        System.out.println("Arcade mode");
         new ArcadeScreen().prepareScene(this.stage);
    }
}
