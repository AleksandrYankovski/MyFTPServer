import controler.Controler;
import javafx.application.Application;
import javafx.stage.Stage;
import view.MainWindow;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        new MainWindow(new Controler());
    }


    public static void main(String[] args) {
        launch(args);
    }
}