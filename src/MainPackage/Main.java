package MainPackage;

import ViewPackage.WelcomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Fruit Ninja");
        new WelcomeScreen().prepareScene(stage);


    }


    public static void main(String[] args) {

        launch(args);
    }



}



