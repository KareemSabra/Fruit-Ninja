package LogicPackage;

import LogicPackage.Misc.MyRandom;

public class DifficutlyController {
    int speedup=0;


    public int getNumberofFruitsWave(){
        int numberofFruitsWave = 0;
        if(PlayerSingleton.getInstance().getCurrentScore()<50) {
             numberofFruitsWave = new MyRandom().getRand(1,3);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<100){
            numberofFruitsWave = new MyRandom().getRand(2,4);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<150){
            numberofFruitsWave = new MyRandom().getRand(3,5);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<200){
            numberofFruitsWave = new MyRandom().getRand(4,6);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<250){
            numberofFruitsWave = new MyRandom().getRand(4,7);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<300){
            numberofFruitsWave = new MyRandom().getRand(5,8);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<350){
            numberofFruitsWave = new MyRandom().getRand(5,9);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<400){
            numberofFruitsWave = new MyRandom().getRand(5,10);
        }

        return numberofFruitsWave;
    }

    public int getNumberofBombsWave(){
        int  numberofBombsWave = 0;
        if(PlayerSingleton.getInstance().getCurrentScore()<50) {
            numberofBombsWave = new MyRandom().getRand(0,1);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<100){
            numberofBombsWave = new MyRandom().getRand(0,2);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<150){
            numberofBombsWave = new MyRandom().getRand(0,3);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<200){
            numberofBombsWave = new MyRandom().getRand(1,3);
        }
        else if (PlayerSingleton.getInstance().getCurrentScore()<350){
            numberofBombsWave = new MyRandom().getRand(1,4);
        }

        return numberofBombsWave ;
    }
    public int getSpeed(){
        if (PlayerSingleton.getInstance().getCurrentScore()>800){
            speedup = 1000;
            return speedup;
        }
        if(PlayerSingleton.getInstance().getCurrentScore()>400){
            speedup=1200;
            return speedup;
        }
        speedup = (int) (2000-PlayerSingleton.getInstance().getCurrentScore()*1.3);
        System.out.println(speedup);
        return speedup;
    }
    public int getFallingSpeed(){
        return (int) speedup/2;
    }
    public int getDownSpeed(){
        return (int) ( speedup/1.5);
    }


}
