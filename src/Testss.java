import java.util.Random;

public class Testss {


    public static void main(String[] args) {
        System.out.println(new MyRandom().getRand(1,5));


    }
}
    class MyRandom{
        public int getRand(int min, int max){
            return (int) (Math.random()*max+ min);
        }
    }





