package LogicPackage.Instantiation.FruitFactory;


import LogicPackage.GameObject;

public class FruitFactory {

    public GameObject getFruitType(){
        int i  = (int )(Math.random() * 2 + 1);

        if(i==1)
            return new Pineapple();
        else
        if (i==2)
            return new Watermelon();

        return null;
    }
}
