package MainPackage;

import ViewPackage.Difficulties;
import ViewPackage.GameMode;
import ViewPackage.WelcomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Fruit Ninja");
        WelcomeScreen welcome = new WelcomeScreen();
        welcome.prepareScene(stage);



    }


    public static void main(String[] args) {

        launch(args);
    }



}



