package model.command;

import model.reply.Reply;
import model.server.FTPServerDTP;
import model.server.connection.ConnectionType;
import model.server.connection.DataConnection;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.lang.String.*;
import static java.lang.String.format;
import static java.lang.String.join;

public final class PASVCommand implements Command {


    private FTPServerDTP ftpServerDTP;
    private ServerSocket serverSocket;

    public PASVCommand(FTPServerDTP ftpServerDTP) {

        this.ftpServerDTP = ftpServerDTP;
        try {
            serverSocket = new ServerSocket(0, 1,
                    InetAddress.getByName(System.getProperty("socket.address")));
        } catch (IOException e) {
            e.printStackTrace();//как нибубь лог впихнуть
        }

    }


    @Override
    public String execute() throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
/*
            try {
                Socket socket = serverSocket.accept();
                ftpServerDTP.createConnection(socket);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
*/
            return String.format(Reply.REPLY_MESSAGE_227,getReplyPassiveAdress());
        });
         return completableFuture.get();
    }





    private String getReplyPassiveAdress() {

        int localPort = serverSocket.getLocalPort();

        return format("%s,%s,%s",
                join(",", serverSocket.getInetAddress().getHostAddress().split("\\.")),
                localPort / 256, localPort % 256);
    }


}
