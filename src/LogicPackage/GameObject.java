package LogicPackage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

public interface GameObject {

    public Enum getObjectType();

    public int getXlocation();

    public int getYlocation();

    public int getMaxHeight();

    public int getInitialVelocity();

    public int getFallingVelocity();

    public Boolean isSliced();

    public Boolean hasMovedOffScreen();

    public void slice();

    public void move(double time);

    public ImageView getFruitImages();


}
