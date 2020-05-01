package LogicPackage.Commands;

import LogicPackage.Mementos.CareTaker;
import LogicPackage.Mementos.Originator;
import LogicPackage.PlayerSingleton;
import ViewPackage.Menus.WelcomeScreen;

public class HoldGame implements GameCommands {
    @Override
    public void execute() {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setCurrentScore(PlayerSingleton.getInstance().getCurrentScore());
        careTaker.add(originator.saveCurrentScoreToMemento());

        originator.setBestScore(PlayerSingleton.getInstance().getBestScore());
        careTaker.add(originator.saveBestScoreToMemento());

        originator.setLives(PlayerSingleton.getInstance().getLivesLeft());
        careTaker.add(originator.saveLivesToMemento());


        //WelcomeScreen.getInstance().prepareScene();
    }
}
