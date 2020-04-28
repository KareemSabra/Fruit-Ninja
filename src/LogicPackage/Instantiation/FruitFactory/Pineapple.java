package LogicPackage.Instantiation.FruitFactory;

import LogicPackage.GameObject;
import LogicPackage.ImportImage;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pineapple implements GameObject {
    private boolean movingUp = true;
    private boolean movedOffScreen = false;
    boolean sliced = false;
    int x, y;


    @Override
    public String getObjectType() {
        return "Pineapple";
    }

    @Override
    public int getXlocation() {

        return (int)((Math.random() *1200 + 0));
    }

    @Override
    public int getYlocation() {

        return (int)((Math.random() * ((720 - 0) + 1)) + 0);
    }

    @Override
    public int getMaxHeight() {

        return 600;
    }

    @Override
    public int getInitialVelocity() {

        return 10;
    }

    @Override
    public int getFallingVelocity() {

        return 50;
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
