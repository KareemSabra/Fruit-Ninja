package LogicPackage.Commands;

import LogicPackage.Misc.StopWatch;
import LogicPackage.PlayerSingleton;
import ViewPackage.GameViewBackgrounds.GameScreen;
import ViewPackage.Menus.WelcomeScreen;

public class EndGame implements GameCommands {
    @Override
    public void execute() {
        StopWatch.getInstance().resetTimer();
        PlayerSingleton.getInstance().destruct();
        GameScreen.stopTimeline();
        WelcomeScreen.getInstance().prepareScene();
    }
}
