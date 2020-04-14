package LogicPackage.Instantiation;

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
}