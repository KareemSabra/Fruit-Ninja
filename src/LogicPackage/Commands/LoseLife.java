package LogicPackage.Commands;

import LogicPackage.PlayerSingleton;
import ViewPackage.GameViewBackgrounds.ClassicScreen;

public class LoseLife implements GameCommands {
    @Override
    public void execute() {
        PlayerSingleton.getInstance().loseLife();
        if (PlayerSingleton.getInstance().getLivesLeft()==0)
        {
            Invoker invoker = new Invoker();
            invoker.setCommands(new EndGame());
            invoker.execute();
        }
        ClassicScreen.loseLifeLabel(PlayerSingleton.getInstance().getLivesLeft());
    }
}
