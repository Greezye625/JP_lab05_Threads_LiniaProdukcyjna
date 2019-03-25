package sample;

import java.util.List;
import java.util.Random;

public class Robot1 extends Thread{
    private int delay;
    final List line1list;

    public Robot1(int delay, final List line1list) {
        this.delay = delay;
        this.line1list = line1list;
    }


    public void run(){
        Random rnd = new Random();


        while(true){
            char c = (char) (rnd.nextInt(26) + 'a');

            if(line1list.get(0).equals(' ')){
                synchronized (line1list) {
                    line1list.set(0, c);
                }
            }
            try {
                Thread.sleep(delay);
            }catch (InterruptedException e){

            }
        }
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
