package LogicPackage;

import LogicPackage.Instantiation.FruitFactory.GameObject;

public interface GameActions {

    public GameObject createGameObject();

    public void updateObjectsLocations();

    public void sliceObjects();

    public void saveGame();


    public void loadGame();

    public void ResetGame();

}
