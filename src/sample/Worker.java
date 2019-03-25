package sample;

import java.util.List;

public class Worker extends Thread {

    private char item;
    final List line1list;
    final List line2list;
    private int station;
    private int delay;

    public Worker(final List line1list, final List line2list, int station, int delay) {
        this.line1list = line1list;
        this.line2list = line2list;
        this.station = station;
        this.delay = delay;
        this.item = ' ';
    }

    public synchronized char getItem() {
        return item;
    }

    public void setItem(char item) {
        this.item = item;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public void run(){
        while (true) {
            if (this.item == ' ') {
                synchronized (line1list) {
                    if (!line1list.get(station).equals(' ')) {
                        this.item = (char) line1list.get(station);
                        line1list.set(station, ' ');
                    }
                }
            }
            else if(this.item <= 'z' && this.item >= 'a'){
                char k = this.item;
                k = Character.toUpperCase(k);
                this.item = k;
            }
            else{
                synchronized (line2list) {
                    if (line2list.get(4-station).equals(' ')) {
                        line2list.set(4-station,this.item);
                        this.item = ' ';
                    }
                }
            }
            try {
                Thread.sleep(delay);
            }
            catch (InterruptedException e){

            }
        }
    }
}
