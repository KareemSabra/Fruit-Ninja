package LogicPackage.Mementos;

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
        Memento memento = new Memento();
        memento.setLives(lives);
        memento.setCurrentScore(currentScore);
        return memento;
    }

}