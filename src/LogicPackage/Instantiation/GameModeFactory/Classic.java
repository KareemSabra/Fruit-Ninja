package LogicPackage.Instantiation.GameModeFactory;

import ViewPackage.ClassicScreen;
import javafx.stage.Stage;

public class Classic implements Mode {
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void gameMode()
    {
        System.out.println("Classic mode");
        new ClassicScreen().prepareScene(stage);
    }
}
