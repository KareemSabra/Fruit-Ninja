package LogicPackage.Instantiation.Game;


import LogicPackage.Instantiation.DifficultyFactory.DifficultyFactory;
import LogicPackage.Instantiation.GameModeFactory.GameModeFactory;

public abstract class Game {
    GameModeFactory g = new GameModeFactory();
    DifficultyFactory d = new DifficultyFactory();

    char gam = g.getGam(), dif = d.getDif();
    float fruitSpeed = d.getFruitSpeed(), fruitTimer = d.getFruitTimer(), bombTimer = d.getBombTimer();

}
