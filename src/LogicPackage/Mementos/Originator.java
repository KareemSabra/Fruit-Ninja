package LogicPackage.Mementos;

import LogicPackage.Misc.ClassicTimer;
import LogicPackage.Misc.SaveTimer;
import LogicPackage.PlayerSingleton;

public class Originator {

    private int currentScore;
    private int lives;


    public void setCurrentScore( ){
        this.currentScore = PlayerSingleton.getInstance().getCurrentScore();
    }
    public void setLives( ){
        this.lives = PlayerSingleton.getInstance().getLivesLeft();
    }

    public int getCurrentScore(){
        return currentScore;
    }
    public int getLives(){return lives;}

    public Memento createMemento(){
        SaveTimer saveTimer = new SaveTimer();
            saveTimer.setMillis(ClassicTimer.getInstance().getMillis());
            saveTimer.setSecs(ClassicTimer.getInstance().getSecs());
            saveTimer.setMins(ClassicTimer.getInstance().getMins());

        Memento memento = new Memento();
        memento.setLives(lives);
        memento.setCurrentScore(currentScore);
        memento.setSaveTimer(saveTimer);
        return memento;
    }

}