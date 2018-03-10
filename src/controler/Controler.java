package controler;

import model.server.FTPServer;

import java.io.IOException;

public final class Controler {

    private FTPServer ftpServer;
    private Thread serverThread;

    public Controler() {
        this.ftpServer = new FTPServer();
    }

    public void startServer() {
        serverThread = new Thread(ftpServer);
        serverThread.start();
    }

    public void stopServer() {
        ftpServer.stop();
        if (serverThread != null) {
            serverThread.interrupt();
        }

    }

    public FTPServer getFtpServer() {
        return ftpServer;
    }

}
