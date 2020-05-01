package LogicPackage.Commands;

import LogicPackage.Misc.ClassicTimer;
import ViewPackage.GameOverScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;

public class EndGame implements GameCommands {
    @Override
    public void execute() {
        GameScreen.stopTimeline();
        ClassicTimer.getInstance().resetTimer();

        GameScreen.stopGame();

        GameOverScreen gameOverScreen = new GameOverScreen();
        gameOverScreen.GameOver();
    }
}
