package LogicPackage.Instantiation.FruitFactory;


import LogicPackage.GameObject;

public class FruitFactory {

    public GameObject getFruitType(String type){
        if(type==null)
            return null;

        if(type.equalsIgnoreCase("Pineapple"))
            return new Pineapple();
        else
        if (type.equalsIgnoreCase("Watermelon"))
            return new Watermelon();

        return null;
    }
}
