package sample;

import java.util.List;

public class Robot2 extends Thread{
    private int delay;
    final List line2list;

    public Robot2(int delay, final List line2list) {
        this.delay = delay;
        this.line2list = line2list;
    }


    public void run(){
        while(true){
            synchronized (line2list) {
                if(!line2list.get(4).equals(' ')){
                    try {
                        Thread.sleep(delay);
                    }
                    catch (InterruptedException e){

                    }
                    line2list.set(4, ' ');
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