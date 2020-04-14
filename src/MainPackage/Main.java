package MainPackage;

import ViewPackage.Difficulties;
import ViewPackage.GameMode;
import ViewPackage.WelcomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Fruit Ninja");
        WelcomeScreen welcome = new WelcomeScreen(primaryStage);
        welcome.prepareScene();



    }


    public static void main(String[] args) {

        launch(args);
    }



}



