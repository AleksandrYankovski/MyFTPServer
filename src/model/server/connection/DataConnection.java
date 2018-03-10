package model.server.connection;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class DataConnection  {


    private Socket socket;
    private BufferedInputStream bis;
    private BufferedOutputStream bos;


    public DataConnection(Socket socket) throws IOException {
        this.socket = socket;
        bis = new BufferedInputStream(socket.getInputStream());
        bos = new BufferedOutputStream(socket.getOutputStream());

    }



    public void close() throws IOException {
      //  log.debug("CLOSE CONNECTION");
        socket.close();
    }



}
