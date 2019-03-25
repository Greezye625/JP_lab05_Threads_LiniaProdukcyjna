package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Controller;

import java.util.ArrayList;
import java.util.List;

public class Line1 extends Thread {

    final List line1list;
    private int delay;


    public Line1(int delay, final List line1list) {
        this.line1list = line1list;
        this.delay = delay;
    }


    public void run() {
        while(true){
            synchronized (line1list) {
                if(line1list.get(4).equals(' ')) {
                    line1list.set(4, line1list.get(3));
                    line1list.set(3, line1list.get(2));
                    line1list.set(2, line1list.get(1));
                    line1list.set(1, line1list.get(0));
                    line1list.set(0, ' ');
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
