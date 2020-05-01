package LogicPackage.Mementos;

public class Originator {

    private int currentScore;
    private int bestScore;
    private int lives;


    public void setCurrentScore(int currentScore){
        this.currentScore = currentScore;
    }
    public void setBestScore(int bestScore){this.bestScore = bestScore;}
    public void setLives(int lives){this.lives = lives;}

    public int getCurrentScore(){
        return currentScore;
    }
    public int getBestScore(){return bestScore;}
    public int getLives(){return lives;}

    public Memento saveCurrentScoreToMemento(){
        return new Memento(currentScore,bestScore,lives);
    }

    public void getCurrentScoreFromMemento(Memento memento){
        currentScore = saveCurrentScoreToMemento().getCurrentScore();
    }

    public void getBestScoreFromMemento(Memento memento){
        currentScore = saveBestScoreToMemento().getBestScore();
    }

    public void getLivesFromMemento(Memento memento){
        currentScore = saveLivesToMemento().getLives();
    }

    public Memento saveBestScoreToMemento(){
        return new Memento(currentScore,bestScore,lives);
    }

    public Memento saveLivesToMemento(){
        return new Memento(currentScore,bestScore,lives);
    }


}