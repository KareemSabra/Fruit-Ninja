package LogicPackage.Instantiation;

import LogicPackage.Instantiation.DifficultyFactoryPackage.Difficulty;
import LogicPackage.Instantiation.DifficultyFactoryPackage.DifficultyFactory;
import LogicPackage.Instantiation.GameModeFactoryPackage.GameModeFactory;
import LogicPackage.Instantiation.GameModeFactoryPackage.Mode;


public class PlayerSingleton {
    private static PlayerSingleton instance;

    private PlayerSingleton() {
    }
    public static PlayerSingleton getInstance(){
        if (instance == null)
            instance = new PlayerSingleton();
        return instance;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        Difficulty difficulty = new DifficultyFactory().getDifficultyLevel(difficultyLevel);
        difficulty.level();
    }

    public void setGameMode(String modeChoice) {
        Mode gameMode = new GameModeFactory().getMode(modeChoice);
        gameMode.gameMode();}

}
