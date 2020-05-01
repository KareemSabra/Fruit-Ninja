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

    public static PlayerSingleton getInstance() {
        if (instance == null)
            instance = new PlayerSingleton();
        return instance;
    }
    public void destruct(){
        instance = null;
    }


    public  void calculateCurrentScore(int Multiplier){
        currentScore +=Multiplier;
        ClassicScreen.setCurrentScoreLabel(String.valueOf(currentScore));
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
