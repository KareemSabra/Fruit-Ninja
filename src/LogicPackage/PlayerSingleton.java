package LogicPackage;

import LogicPackage.Factories.DifficultyFactory.Difficulty;
import LogicPackage.Factories.DifficultyFactory.DifficultyFactory;

import LogicPackage.Factories.FruitFactory.FruitFactory;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
import ViewPackage.Menus.SettingsScreen;


public class PlayerSingleton {
    private static PlayerSingleton instance;
    private static int currentScore = 0;
    private static int bestScore = 0;

    private PlayerSingleton() {
        setDifficultyLevel();
    }

    public static PlayerSingleton getInstance() {
        if (instance == null)
            instance = new PlayerSingleton();
        else instance.setDifficultyLevel();
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


    public static void calculateCurrentScore(int Multiplier){
        currentScore +=Multiplier;
        ClassicScreen.setCurrentScoreLabel(String.valueOf(currentScore));
    }

    public static int getCurrentScore(){
        return currentScore;
    }

    public static int getBestScore(){
        return bestScore;
    }


}
