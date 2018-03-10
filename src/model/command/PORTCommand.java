package model.command;

import model.reply.Reply;
import model.server.FTPServerDTP;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import static java.lang.Integer.parseInt;

public final class PORTCommand implements Command {


    private String[] args;
    private FTPServerDTP ftpServerDTP;


    public PORTCommand(String param, FTPServerDTP ftpServerDTP) {
        this.args = param.split(",");
        this.ftpServerDTP = ftpServerDTP;
    }


    @Override
    public String execute() throws IOException {



        String host = String.join(".", args[0], args[1], args[2], args[3]);
        ftpServerDTP.createConnection(host, (parseInt(args[4]) << 8) + parseInt(args[5]));


        return Reply.REPLY_MESSAGE_200;
    }
}
