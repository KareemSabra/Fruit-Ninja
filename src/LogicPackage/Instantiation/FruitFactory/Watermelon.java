package LogicPackage.Instantiation.FruitFactory;

import LogicPackage.GameObject;
import javafx.scene.image.Image;

public class Watermelon implements GameObject {

    private boolean movingUp = true;
    private boolean movedOffScreen = false;
    boolean sliced = false;
    int x, y;


    @Override
    public String getObjectType() {
        return "Watermelon";
    }

    @Override
    public int getXlocation() {

        return x;
    }

    @Override
    public int getYlocation() {

        return y;
    }

    @Override
    public int getMaxHeight() {

        return 500;
    }

    @Override
    public int getInitialVelocity() {

        return 7;
    }

    @Override
    public int getFallingVelocity() {

        return 80;
    }

    @Override
    public Boolean isSliced() {

        return sliced;
    }

    @Override
    public Boolean hasMovedOffScreen() {

        return movedOffScreen;
    }

    @Override
    public void slice() {
        sliced = true;
    }

    @Override
    public void move(double time) {

    }

    @Override
    public Image[] getImages() {
        return new Image[0];
    }

}
