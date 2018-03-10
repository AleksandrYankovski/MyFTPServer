package model.server;

import model.observer.Observable;
import model.observer.Observer;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public final class FTPServer implements Runnable, Observable {

    private ServerSocket serverSocket;
    private List<Observer> observerList;


    public FTPServer() {
        observerList = new ArrayList<>();
    }


    public void stop() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            updateLog(e.getMessage() + "\n");
        }catch (NullPointerException e)
        {
            updateLog("Server was not started"+"\n");
        }
    }


    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(2021);
            while (true) {
                Socket socket = this.serverSocket.accept();
                FTPServerPI serverPI = new FTPServerPI(this, socket);
                serverPI.start();
            }
        } catch (IOException e) {
            updateLog(e.getMessage() + "\n");
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void updateLog(String log) {
        for (Observer tempObserver : observerList) {
            tempObserver.printLog(log);
        }

    }
}

