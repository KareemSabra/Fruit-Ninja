package LogicPackage.Mementos;

public class Memento {

    private int currentScore;

    public Memento(int currentScore){
        this.currentScore = currentScore;
    }

    public int getCurrentScore(){
        return currentScore;
    }
}
