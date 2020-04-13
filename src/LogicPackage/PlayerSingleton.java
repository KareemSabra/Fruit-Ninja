package LogicPackage;

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
        //TODO : Set difficulty

    }
}
