package LogicPackage.Instantiation.FruitFactory;


public class FruitFactory {

    public Fruit getFruitType(String type){
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
