package LogicPackage.Instantiation.GameModeFactory;


import javafx.stage.Stage;

public class GameModeFactory {

    char gam;

    public Mode getMode(String mode, Stage stage)
    {
        if(mode==null)
        { return null;}
        if(mode.equalsIgnoreCase("Arcade"))
        {
            Arcade arcade = new Arcade();
            arcade.setStage(stage);
            arcade.gameMode();
            return arcade;
        }
        else if (mode.equalsIgnoreCase("Classic"))
        {
            Classic classic = new Classic();
            classic.setStage(stage);
            classic.gameMode();
            return classic;
        }

        return null;
    }
    public char getGam() {
        return gam;
    }

    public void setGam(char gam) {
        this.gam = gam;
    }
}
