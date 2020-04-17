package MainPackage;

import ViewPackage.WelcomeScreen;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Fruit Ninja");
        try {
            stage.getIcons().add(new ImportImage().getImage("MainIcon.png"));
        }catch(Exception e)
        {
            System.out.println("Icon cannot be Found !");
        }
        new WelcomeScreen().prepareScene(stage);


    }


    public static void main(String[] args) {

        launch(args);
    }



}



