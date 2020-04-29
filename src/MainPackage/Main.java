package MainPackage;

import LogicPackage.Misc.ImportImage;
import ViewPackage.Menus.WelcomeScreen;
import javafx.application.Application;
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
        WelcomeScreen welcomeScreen =  WelcomeScreen.getInstance();
        WelcomeScreen.setStage(stage);
        welcomeScreen.prepareScene();
    }


    public static void main(String[] args) {

        launch(args);
    }



}



