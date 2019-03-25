package sample;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    final List line1list = new ArrayList();

    final List line2list = new ArrayList();

    @FXML
    public Label lineonelabel0;

    @FXML
    public Label lineonelabel1;

    @FXML
    public Label lineonelabel2;

    @FXML
    public Label lineonelabel3;

    @FXML
    public Label lineonelabel4;

    @FXML
    public Label linetwolabel0;

    @FXML
    public Label linetwolabel1;

    @FXML
    public Label linetwolabel2;

    @FXML
    public Label linetwolabel3;

    @FXML
    public Label linetwolabel4;

    @FXML
    private Label r1insetup;

    @FXML
    private Label r1insetdown;

    @FXML
    private Label worker0label;

    @FXML
    private Label worker1label;

    @FXML
    private Label worker2label;

    @FXML
    private Label worker3label;

    @FXML
    private Label worker4label;

    @FXML
    private Spinner spinnerRobot1;

    @FXML
    private Spinner spinnerRobot2;

    @FXML
    private Spinner spinnerRobot3;

    @FXML
    private Spinner spinnerRobot4;

    @FXML
    private Spinner spinnerLine1;

    @FXML
    private Spinner spinnerLine2;

    @FXML
    private Spinner spinnerWorker0;

    @FXML
    private Spinner spinnerWorker1;

    @FXML
    private Spinner spinnerWorker2;

    @FXML
    private Spinner spinnerWorker3;

    @FXML
    private Spinner spinnerWorker4;

    Worker worker0 = new Worker(line1list, line2list, 0, 2000);
    Worker worker1 = new Worker(line1list, line2list, 1, 1000);
    Worker worker2 = new Worker(line1list, line2list, 2, 1800);
    Worker worker3 = new Worker(line1list, line2list, 3, 1500);
    Worker worker4 = new Worker(line1list, line2list, 4, 900);

    Line1 line1 = new Line1(1500, line1list);
    Line1 line2 = new Line1(1500, line2list);
    Robot1 robot1 = new Robot1(700, line1list);
    Robot1 robot2 = new Robot1(900, line1list);
    Robot2 robot3 = new Robot2(1200, line2list);
    Robot2 robot4 = new Robot2(800, line2list);



    @FXML
    public void initialize() {


        line1list.add(' ');
        line1list.add(' ');
        line1list.add(' ');
        line1list.add(' ');
        line1list.add(' ');

        line2list.add(' ');
        line2list.add(' ');
        line2list.add(' ');
        line2list.add(' ');
        line2list.add(' ');

        refresh();


        robot1.start();
        robot2.start();

        line1.start();
        line2.start();

        worker0.start();
        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

        robot3.start();
        robot4.start();


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                    }
                });

            }
        }, 0, 1);

    }

    public void refresh() {
        lineonelabel0.setText(String.valueOf(line1list.get(0)));
        lineonelabel1.setText(String.valueOf(line1list.get(1)));
        lineonelabel2.setText(String.valueOf(line1list.get(2)));
        lineonelabel3.setText(String.valueOf(line1list.get(3)));
        lineonelabel4.setText(String.valueOf(line1list.get(4)));


        linetwolabel0.setText(String.valueOf(line2list.get(4)));
        linetwolabel1.setText(String.valueOf(line2list.get(3)));
        linetwolabel2.setText(String.valueOf(line2list.get(2)));
        linetwolabel3.setText(String.valueOf(line2list.get(1)));
        linetwolabel4.setText(String.valueOf(line2list.get(0)));

        worker0label.setText(String.valueOf(worker0.getItem()));
        worker1label.setText(String.valueOf(worker1.getItem()));
        worker2label.setText(String.valueOf(worker2.getItem()));
        worker3label.setText(String.valueOf(worker3.getItem()));
        worker4label.setText(String.valueOf(worker4.getItem()));
    }


    @FXML
    public void ButtonClicked() {

        line1.setDelay((int)spinnerLine1.getValue());
        line2.setDelay((int)spinnerLine2.getValue());
        robot1.setDelay((int)spinnerRobot1.getValue());
        robot2.setDelay((int)spinnerRobot2.getValue());
        robot3.setDelay((int)spinnerRobot3.getValue());
        robot4.setDelay((int)spinnerRobot4.getValue());
        worker0.setDelay((int)spinnerWorker0.getValue());
        worker1.setDelay((int)spinnerWorker1.getValue());
        worker2.setDelay((int)spinnerWorker2.getValue());
        worker3.setDelay((int)spinnerWorker3.getValue());
        worker4.setDelay((int)spinnerWorker4.getValue());
        
    }
}



