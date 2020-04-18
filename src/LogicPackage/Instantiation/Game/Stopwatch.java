package LogicPackage.Instantiation.Game;

public class Stopwatch extends Thread{

    private long startTime;
    private boolean started;

    public int startThread()
    {
        this.startTime = System.currentTimeMillis();
        setStarted(true);
        this.start();
        return (int)(startTime);
    }

    //public void run(){}

    /*public int[] getTime()
    {
        long milliTime = System.currentTimeMillis() - this.startTime;
        int[] out = new int[]{0,0,0,0};
        out[0] = (int)(milliTime / 3600000);
        out[1] = (int)(milliTime / 60000) % 60;
        out[2] = (int)(milliTime / 1000) % 60;
        out[3] = (int)(milliTime) %1000;
        return out;
    }*/

    public int getTimeElapsed(long startTime)
    {
        return (int)((System.currentTimeMillis() - startTime)/(1000)%60);
    }

    public int getMinutes()
    {
        return (int) (System.currentTimeMillis()/(1000*60)%60);
    }

    public int getSeconds()
    {
        return (int)(System.currentTimeMillis()/(1000)%60);
    }

    public void stopThread()
    {
        setStarted(false);
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }
}
