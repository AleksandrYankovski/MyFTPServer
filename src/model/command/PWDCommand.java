package model.command;

import model.reply.Reply;
import model.server.FTPServerDTP;

public final class PWDCommand implements Command {


    private FTPServerDTP ftpServerDTP;


    public PWDCommand(FTPServerDTP ftpServerDTP) {
        this.ftpServerDTP = ftpServerDTP;
    }

    @Override
    public String execute() {
        return String.format(Reply.REPLY_MESSAGE_257, ftpServerDTP.getParametrs().getCurDirPath());
    }
}
