package LogicPackage.Commands;

import LogicPackage.Misc.ClassicTimer;
import ViewPackage.GameOverScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;

import java.io.File;
import java.io.FileNotFoundException;

public class EndGame implements GameCommands {
    @Override
    public void execute() {
        try {
            File oldMemento = new File("Memento.xml");
            oldMemento.delete();
        }
        catch (Exception e)
        {
            System.out.println("Memento notfound");
        }
        ClassicTimer.getInstance().resetTimer();

        GameScreen.getGameScreen().stopGame();

        GameOverScreen gameOverScreen = new GameOverScreen();
        gameOverScreen.GameOver();
    }
}
