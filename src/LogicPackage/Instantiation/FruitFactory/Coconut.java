package LogicPackage.Instantiation.FruitFactory;

import LogicPackage.GameObject;
import LogicPackage.ImportImage;
import javafx.scene.layout.*;

public class Coconut implements GameObject {

    private boolean movingUp = true;
    private boolean movedOffScreen = false;
    boolean sliced = false;
    int x, y;


    @Override
    public String getObjectType() {
        return "Coconut";
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
        return 650;
    }

    @Override
    public int getInitialVelocity() {
        return 8;
    }

    @Override
    public int getFallingVelocity() {
        return 45;
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
    public Background getImages() {
        Background returnBackground = null;

        BackgroundImage coconutImage = new BackgroundImage(new ImportImage().getImage("Coconut.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        BackgroundImage coconutSlicedImage = new BackgroundImage(new ImportImage().getImage("CoconutSliced.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        if(isSliced() == false)
        {
            returnBackground = new Background(coconutImage);
        }

        if(isSliced() == true)
        {
            returnBackground = new Background(coconutSlicedImage);
        }

        return returnBackground;
    }
}