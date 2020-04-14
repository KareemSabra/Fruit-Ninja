package LogicPackage.Instantiation.DifficultyFactoryPackage;

public class DifficultyFactory {

    public Difficulty getDifficultyLevel(String level){
        if(level==null)
        return null;


        if(level.equalsIgnoreCase("Easy"))
        return new EasyLevel();
        else
            if (level.equalsIgnoreCase("Medium"))
                return new MediumLevel();
        else
            if (level.equalsIgnoreCase("Hard"))
                return new HardLevel();

            return null;
        }

}
