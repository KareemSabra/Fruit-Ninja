package LogicPackage.Instantiation.FruitFactory;

import LogicPackage.GameObject;
import LogicPackage.ImportImage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Pineapple implements GameObject {
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

        return (int)((Math.random() * ((1280 - 0) + 1)) + 0);
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

        return 40;
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
        Image pineapple = new ImportImage().getImage("Pineapple (1).png");

        Image pineappleSliced = new ImportImage().getImage("PineappleSliced (1)");

        ImageView returnImage = new ImageView();

        if(isSliced()==true)
        {
            returnImage.setImage(pineappleSliced);
        }

        if(isSliced()==false)
        {
            returnImage.setImage(pineapple);
        }
        return returnImage;
    }

}
