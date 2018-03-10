package view;

import controler.Controler;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import view.listener.StartServerListener;
import view.listener.StopServerListener;

public final class MainWindow {


    private Controler controler;
    private LogArea logArea;
    private Stage primaryStage;
    private AnchorPane root;
    private Scene scene;


    public MainWindow(Controler controler) {

        this.controler = controler;
        this.logArea=new LogArea(this.controler);
        this.primaryStage=new Stage();


        root = new AnchorPane();

        createMainWindow();

        this.primaryStage.setTitle("FTP server");
        this.primaryStage.show();

    }

    private void createMainWindow()
    {

        scene=new Scene(root,700,487);
        root.setStyle("-fx-background-color: green;");


        createButton("startServer",new StartServerListener(controler),470.0);
        createButton("stopServer",new StopServerListener(controler),580.0);

        root.getChildren().add(logArea.getArea());
        AnchorPane.setTopAnchor(logArea.getArea(),80.0);
        AnchorPane.setLeftAnchor(logArea.getArea(),240.0);


        primaryStage.setScene(scene);
    }


    private void createButton(String name, EventHandler eventHandler,double deltaValue) {
        Button button = new Button();
        button.setText(name);
        button.setOnAction(eventHandler);
        button.setPrefSize(110, 35);
        root.getChildren().add(button);
        AnchorPane.setLeftAnchor(button,deltaValue);
        AnchorPane.setTopAnchor(button,20.0);
    }

}


