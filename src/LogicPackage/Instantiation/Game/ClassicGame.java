package LogicPackage.Instantiation.Game;

import javafx.stage.Stage;
import java.util.Arrays;

public class ClassicGame extends Game {
    {
        int lives = 3, score, bestScore;
        long startTime = 0;
        Stopwatch watch = new Stopwatch();

        while (lives > 0) {

            if (watch.isStarted()) startTime = watch.startThread();
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lives--;

            System.out.print(watch.getMinutes() + ":");
            System.out.println(watch.getSeconds());
            System.out.println("Time elapsed: " + watch.getTimeElapsed(startTime));

        }
        watch.stopThread();

    }

}
