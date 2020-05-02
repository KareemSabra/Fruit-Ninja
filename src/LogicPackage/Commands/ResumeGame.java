package LogicPackage.Commands;

import LogicPackage.PlayerSingleton;
import MainPackage.Main;
import ViewPackage.GameViewBackgrounds.GameScreen;

public class ResumeGame implements GameCommands {
    @Override
    public void execute() {
        PlayerSingleton.getInstance().setPaused(false);
        new GameScreen("Classic", Main.stage);
    }
}
