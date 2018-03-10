package model.server;

import model.CommandCreator;
import model.command.Command;
import model.command.QUITCommand;
import model.reply.Reply;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class FTPServerPI implements Runnable {

    private FTPServerDTP ftpServerDTP;
    private FTPServer server;
    private BufferedReader reader;
    private BufferedWriter writer;

    private Thread thread;


    public FTPServerPI(FTPServer server, Socket socket) throws IOException {
        this.server = server;
        this.ftpServerDTP = new FTPServerDTP();

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        sendMessage(Reply.REPLY_MESSAGE_220);
    }

    @Override
    public void run() {
        connection();
    }

    public void start() {
        this.thread = new Thread(this);
        this.thread.start();
    }


    private void connection() {
        while (true) {
            try {
                Command request = receiveMessage();
                String replyMessage = request.execute();
                sendMessage(replyMessage);
                if (request instanceof QUITCommand) {
                    break;
                }
            } catch (IOException e) {
                server.updateLog(e.getMessage() + "\n");
                break;
            } catch (IllegalStateException e) {
                server.updateLog(e.getMessage());
                break;
            }catch (ExecutionException e) {
                server.updateLog(e.getMessage());
            } catch (InterruptedException e) {
                server.updateLog(e.getMessage());
            }

        }
    }

    private void sendMessage(String message) throws IOException {
        this.writer.write(message);
        this.writer.flush();
        server.updateLog(message);
    }

    private Command receiveMessage() throws IOException {
        String message = reader.readLine();
        if (message != null) {
            server.updateLog(message + "\n");
            return CommandCreator.getCommand(message, ftpServerDTP);
        } else {
            throw new IOException("Connection is close");
        }
    }
}
