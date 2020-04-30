package LogicPackage;

import LogicPackage.Commands.EndGame;
import LogicPackage.Commands.Invoker;
import LogicPackage.Commands.LoseLife;
import LogicPackage.Factories.DifficultyFactory.Difficulty;
import LogicPackage.Factories.DifficultyFactory.DifficultyFactory;

import LogicPackage.Factories.FruitFactory.FruitFactory;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
import ViewPackage.Menus.SettingsScreen;


public class PlayerSingleton {
    private static PlayerSingleton instance;
    private  int currentScore = 0;
    private  int bestScore = 0;
    private  int livesLeft = 3 ;
    private int fruitsPerWave = 0;
    private int slicedFruits = 0;

    public void setFruitsPerWave(int fruitsPerWave) {
        this.fruitsPerWave = fruitsPerWave;
    }

    public void sliceFruit( ) {
        this.slicedFruits ++;
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void compareSliced(){
        int diff = fruitsPerWave-slicedFruits;
        if(diff > 0){
            for (int i =0 ; i <diff; i++) {
                Invoker invoker = new Invoker();
                invoker.setCommands(new LoseLife());
                invoker.execute();
            }
        }
    }
    public void resetFruits(){
        fruitsPerWave = 0;
        slicedFruits = 0;
    }


    private PlayerSingleton() {
        setDifficultyLevel();
    }

    public static PlayerSingleton getInstance() {
        if (instance == null)
            instance = new PlayerSingleton();
        //else instance.setDifficultyLevel();
        return instance;
    }
    public void setDifficultyLevel() {
        String difficultyLevel = SettingsScreen.getInstance().getDifficulty();
        Difficulty difficulty = new DifficultyFactory().getDifficultyLevel(difficultyLevel);
        difficulty.level();
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
