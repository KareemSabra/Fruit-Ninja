package LogicPackage;

public class PlayerSingleton {
    private static PlayerSingleton instance;
    private String difficultyLevel;

    private PlayerSingleton() {
    }
    public static PlayerSingleton getInstance(){
        if (instance == null)
            instance = new PlayerSingleton();
        return instance;
    }
    //TODO : Set difficulty

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
