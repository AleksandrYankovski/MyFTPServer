package model.server;

import model.server.connection.ConnectionType;
import model.server.connection.DataConnection;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public final class FTPServerDTP {


    private FTPTransferParametrs ftpParametrs;
    private DataConnection dataConnection;

    public FTPServerDTP() {
        ftpParametrs = new FTPTransferParametrs();
    }


    public FTPTransferParametrs getParametrs() {
        return ftpParametrs;
    }

    public void createConnection(Socket socket) throws IOException {
        ftpParametrs.setConnectionType(ConnectionType.PASV);
        dataConnection = new DataConnection(socket);
    }

    public void createConnection(String host, int i) throws IOException {

        Socket socket = new Socket(host, i);
        ftpParametrs.setConnectionType(ConnectionType.PORT);
        if (dataConnection != null) dataConnection.close();
        dataConnection = new DataConnection(socket);
    }


    public DataConnection getDataConnection() {
        return dataConnection;
    }
}
