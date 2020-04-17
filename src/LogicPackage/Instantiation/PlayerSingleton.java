package LogicPackage.Instantiation;

import LogicPackage.Instantiation.DifficultyFactory.Difficulty;
import LogicPackage.Instantiation.DifficultyFactory.DifficultyFactory;
import LogicPackage.Instantiation.GameModeFactory.GameModeFactory;
import LogicPackage.Instantiation.GameModeFactory.Mode;
import ViewPackage.SettingsScreen;


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
