package MainPackage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImportImage {

    public Image getImage(String fileName) {

        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);

            return new Image(fileInputStream);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Image not found");
            return null;
        }

    }
}
