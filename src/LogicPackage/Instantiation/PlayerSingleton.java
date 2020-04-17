package LogicPackage.Instantiation;

import LogicPackage.Instantiation.DifficultyFactory.Difficulty;
import LogicPackage.Instantiation.DifficultyFactory.DifficultyFactory;

import ViewPackage.Menus.SettingsScreen;


public class PlayerSingleton {
    private static PlayerSingleton instance;

    private PlayerSingleton() {
        setDifficultyLevel();
    }

    public static PlayerSingleton getInstance() {
        if (instance == null)
            instance = new PlayerSingleton();
        return instance;
    }

    public void setDifficultyLevel() {
        String difficultyLevel = SettingsScreen.getInstance().getDifficulty();
        Difficulty difficulty = new DifficultyFactory().getDifficultyLevel(difficultyLevel);
        difficulty.level();
    }

}
