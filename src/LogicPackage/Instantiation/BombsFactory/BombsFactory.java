package LogicPackage.Instantiation.BombsFactory;

import LogicPackage.GameObject;

public class BombsFactory {

    public GameObject getBombType( ){
        int i  = (int )(Math.random() * 2 + 1);

        if(i == 1)
            return (GameObject) new LuckyBlastBomb();
        else
        if (i==2)
            return (GameObject) new RedBomb();

        return null;
    }
}
