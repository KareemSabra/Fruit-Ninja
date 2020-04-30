package LogicPackage.Commands;

import LogicPackage.Misc.StopWatch;
import LogicPackage.PlayerSingleton;
import ViewPackage.GameOverScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;
import ViewPackage.Menus.WelcomeScreen;

public class EndGame implements GameCommands {
    @Override
    public void execute() {
        GameOverScreen gameOverScreen = new GameOverScreen();
        gameOverScreen.GameOver();
    }
}
