package LogicPackage;

import LogicPackage.Factories.DifficultyFactory.Difficulty;
import LogicPackage.Factories.DifficultyFactory.DifficultyFactory;

import LogicPackage.Factories.FruitFactory.FruitFactory;
import ViewPackage.Menus.SettingsScreen;


public class PlayerSingleton implements GameActions {
    private static PlayerSingleton instance;

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


    private static int currentScore = 0;
    private static int bestScore = 0;

    public static void calculateCurrentScore(){
        currentScore ++;
    }

    public static void calculateBestScore(){
        bestScore ++;
    }

    public static int getCurrentScore(){
        return currentScore;
    }

    public static int getBestScore(){
        return bestScore;
    }

    @Override
    public GameObject createGameObject() {
        return new FruitFactory().getFruitType();
    }

    @Override
    public void updateObjectsLocations() {

    }

    @Override
    public void sliceObjects() {

    }

    @Override
    public void saveGame() {

    }

    @Override
    public void loadGame() {

    }

    @Override
    public void ResetGame() {

    }
}
