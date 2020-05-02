package LogicPackage.Commands;

import LogicPackage.Misc.ClassicTimer;
import LogicPackage.PlayerSingleton;
import MainPackage.Main;
import ViewPackage.GameViewBackgrounds.GameScreen;

public class StartNewGame implements GameCommands {
    @Override
    public void execute() {
        PlayerSingleton.getInstance().setPaused(false);
        ClassicTimer.getInstance().resetTimer();
        PlayerSingleton.getInstance().destruct();
        new GameScreen("Classic", Main.stage);
    }
}
