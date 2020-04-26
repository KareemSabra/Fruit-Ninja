package LogicPackage.Instantiation.FruitFactory;

import LogicPackage.GameObject;
import LogicPackage.ImportImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Watermelon implements GameObject {

    private boolean movingUp = true;
    private boolean movedOffScreen = false;
    boolean sliced = false;
    int x, y;


    @Override
    public Enum getObjectType() {
        return null;
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

        return 30;
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
        sliced = false;
    }

    @Override
    public void move(double time) {

    }

    @Override
    public ImageView getFruitImages() {
            Image watermelon = new ImportImage().getImage("Watermelon (1).png");

            Image watermelonSliced = new ImportImage().getImage("WatermelonSliced (1)");

            ImageView returnImage = new ImageView();

            if(isSliced()==true)
            {
                returnImage.setImage(watermelonSliced);
            }

            if(isSliced()==false)
            {
                returnImage.setImage(watermelon);
            }
            return returnImage;
    }

}
