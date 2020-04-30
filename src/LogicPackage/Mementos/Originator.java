package LogicPackage.Mementos;

public class Originator {

    private int currentScore;


    public void setCurrentScore(int currentScore){
        this.currentScore = currentScore;
    }

    public int getCurrentScore(){
        return currentScore;
    }

    public Memento saveCurrentScoreToMemento(){
        return new Memento(currentScore);
    }

    public void getCurrentScoreFromMemento(Memento memento){
        currentScore = saveCurrentScoreToMemento().getCurrentScore();
    }

    public Memento saveBestScoreToMemento(){
        return new Memento(currentScore);
    }


}