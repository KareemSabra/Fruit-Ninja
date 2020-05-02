package LogicPackage;

import ViewPackage.GameViewBackgrounds.ClassicScreen;


public class PlayerSingleton {
    private static PlayerSingleton instance;
    private  int currentScore = 0;
    private  int bestScore = 0;
    private  int livesLeft = 3 ;




    public int getLivesLeft() {
        return livesLeft;
    }

    private PlayerSingleton() {

    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public static PlayerSingleton getInstance() {
        if (instance == null)
            instance = new PlayerSingleton();
        return instance;
    }
    public void destruct(){

        currentScore = 0;
        livesLeft = 3;

    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public  void calculateCurrentScore(int Multiplier){
        currentScore +=Multiplier;
        ClassicScreen.setCurrentScoreLabel();
    }
    public void loseLife(){
        System.out.println("Life lost");
        livesLeft--;
    }


    public  int getCurrentScore(){
        return currentScore;
    }

    public  int getBestScore(){
        return bestScore;
    }


}
