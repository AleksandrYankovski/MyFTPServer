package view.listener;

import controler.Controler;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.io.IOException;

public final class StopServerListener implements EventHandler {

    private Controler controler;

    public StopServerListener(Controler controler)
    {
        this.controler=controler;
    }

    @Override
    public void handle(Event event) {
        controler.stopServer();
    }
}
