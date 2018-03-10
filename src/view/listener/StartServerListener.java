package view.listener;

import controler.Controler;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.io.IOException;

public final class StartServerListener implements EventHandler {


    private Controler controler;

    public StartServerListener(Controler controler) {
        this.controler = controler;
    }

    @Override
    public void handle(Event event) {
            controler.startServer();
    }
}