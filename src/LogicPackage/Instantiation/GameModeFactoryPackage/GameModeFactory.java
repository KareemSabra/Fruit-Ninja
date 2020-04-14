package LogicPackage.Instantiation.GameModeFactoryPackage;


public class GameModeFactory {

    public Mode getMode(String mode)
    {
        if(mode==null)
        { return null;}
        if(mode.equalsIgnoreCase("Arcade")) {return new Arcade();}
        else if (mode.equalsIgnoreCase("Classic")){ return new Classic();}
        return null;
    }
}
