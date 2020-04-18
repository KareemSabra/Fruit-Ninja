package MainPackage;

import LogicPackage.ImportImage;
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
         WelcomeScreen.getInstance().prepareScene(stage);


    }


    public static void main(String[] args) {

        launch(args);
    }



}



