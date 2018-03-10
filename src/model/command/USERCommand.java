package model.command;

import model.reply.Reply;
import model.server.FTPServerDTP;

public final class USERCommand implements Command {

    private String login;
    private FTPServerDTP ftpServerDTP;

    public USERCommand(String login, FTPServerDTP ftpServerDTP) {
        this.login = login;
        this.ftpServerDTP = ftpServerDTP;
    }

    @Override
    public String execute() {
        if (login.isEmpty())
            return Reply.REPLY_MESSAGE_501;
        else {
            ftpServerDTP.getParametrs().setLogin(login);
            return String.format(Reply.REPLY_MESSAGE_331, login);
        }
    }
}
