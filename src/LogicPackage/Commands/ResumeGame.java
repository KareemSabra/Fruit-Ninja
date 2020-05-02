package LogicPackage.Commands;

import MainPackage.Main;
import ViewPackage.GameViewBackgrounds.GameScreen;

public class ResumeGame implements GameCommands {
    @Override
    public void execute() {
        new GameScreen("Classic", Main.stage);
    }
}
