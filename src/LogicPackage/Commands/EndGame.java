package LogicPackage.Commands;

import LogicPackage.Misc.ClassicTimer;
import ViewPackage.GameOverScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;

public class EndGame implements GameCommands {
    @Override
    public void execute() {
        ClassicTimer.getInstance().resetTimer();

        GameScreen.getGameScreen().stopGame();

        GameOverScreen gameOverScreen = new GameOverScreen();
        gameOverScreen.GameOver();
    }
}
