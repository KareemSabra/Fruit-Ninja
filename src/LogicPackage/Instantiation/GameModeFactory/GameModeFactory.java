package LogicPackage.Instantiation.GameModeFactory;


import javafx.stage.Stage;

public class GameModeFactory {

    public Mode getMode(String mode, Stage stage)
    {
        if(mode==null)
        { return null;}
        if(mode.equalsIgnoreCase("Arcade")) {
            Arcade arcade = new Arcade();
        arcade.setStage(stage);
        return arcade;}
        else if (mode.equalsIgnoreCase("Classic")){ return new Classic();}
        return null;
    }
}
