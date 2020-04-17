package LogicPackage.Instantiation.DifficultyFactory;

import LogicPackage.Instantiation.GameModeFactory.GameModeFactory;

public class EasyLevel implements Difficulty {
    @Override
    public void level() {
        DifficultyFactory d = new DifficultyFactory();
        d.setBombTimer(1);
        d.setFruitSpeed(1);
        d.setFruitTimer(1);
        d.setDif('E');

        System.out.println("Easy Level");
    }
}
