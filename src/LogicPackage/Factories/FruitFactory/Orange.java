package LogicPackage.Factories.FruitFactory;

import LogicPackage.GameObject;
import LogicPackage.Misc.ImportImage;
import LogicPackage.PlayerSingleton;
import javafx.scene.layout.*;

public class Orange implements GameObject {

    private boolean movingUp = true;
    private boolean movedOffScreen = false;
    boolean sliced = false;
    int x, y;


    @Override
    public String getObjectType() {
        return "Orange";
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
        return 700;
    }

    @Override
    public int getInitialVelocity() {
        return 12;
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
        PlayerSingleton.getInstance().calculateCurrentScore(getScoreMultiplier());

        sliced = true;
    }

    @Override
    public void move(double time) {

    }

    @Override
    public Background getImages() {
        Background returnBackground = null;

        BackgroundImage orangeImage = new BackgroundImage(new ImportImage().getImage("Orange.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        BackgroundImage orangeSlicedImage = new BackgroundImage(new ImportImage().getImage("OrangeSliced.png"), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);

        if(isSliced() == false)
        {
            returnBackground = new Background(orangeImage);
        }

        if(isSliced() == true)
        {
            returnBackground = new Background(orangeSlicedImage);
        }

        return returnBackground;
    }

    @Override
    public int getScoreMultiplier(){
        return 1;
    }
    @Override
    public void setSliced() {
        sliced = true ;
    }
}
