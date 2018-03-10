package view;

import controler.Controler;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import model.observer.Observer;

public final class LogArea implements Observer {

    private Controler controler;
    private TextArea logArea;


    public LogArea(Controler controler) {
        this.controler = controler;
        this.controler.getFtpServer().addObserver(this);
        logArea = new TextArea();
        logArea.setPrefSize(450, 400);
        this.logArea.setEditable(true);
    }

    public TextArea getArea() {
        return logArea;
    }



    @Override
    public void printLog(String log) {
        Platform.runLater(() -> this.logArea.appendText(log));
    }
}
