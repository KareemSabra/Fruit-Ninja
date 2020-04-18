package LogicPackage.Instantiation.BombsFactory;

public class BombsFactory {

    public Bombs getBombType(String type){
        if(type==null)
            return null;

        if(type.equalsIgnoreCase("Lucky Blast Bomb"))
            return (Bombs) new LuckyBlastBomb();
        else
        if (type.equalsIgnoreCase("Red Bombs"))
            return (Bombs) new RedBomb();

        return null;
    }
}
