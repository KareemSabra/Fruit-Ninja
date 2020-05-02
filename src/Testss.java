import LogicPackage.Commands.SaveGame;
import LogicPackage.Commands.Invoker;

public class Testss{

    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommands(new SaveGame());
        invoker.execute();
    }

}