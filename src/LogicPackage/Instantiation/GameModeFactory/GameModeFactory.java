package LogicPackage.Instantiation.GameModeFactory;


import ViewPackage.GameViewBackgrounds.ArcadeScreen;
import ViewPackage.GameViewBackgrounds.ClassicScreen;
import ViewPackage.GameViewBackgrounds.GameScreen;
import javafx.stage.Stage;

public class GameModeFactory {

    char gam;

    public GameScreen getMode(String mode, Stage stage)
    {
        if(mode==null)
        { return null;}
        if(mode.equalsIgnoreCase("Arcade"))
        {
            return new ArcadeScreen();
        }
        else if (mode.equalsIgnoreCase("Classic"))
        {
          return  new ClassicScreen();
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
