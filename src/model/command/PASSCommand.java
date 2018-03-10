package model.command;

import model.reply.Reply;
import model.server.FTPTransferParametrs;
import model.server.FTPServerDTP;

public final class PASSCommand implements Command {


    private String passowrd;
    private FTPServerDTP ftpServerDTP;


    public PASSCommand(String password, FTPServerDTP ftpServerDTP) {
        this.passowrd = password;
        this.ftpServerDTP = ftpServerDTP;

    }


    @Override
    public String execute() {
        FTPTransferParametrs ftpParametrs = ftpServerDTP.getParametrs();
        String login = ftpParametrs.getLogin();
        if (login.isEmpty())
            return Reply.REPLY_MESSAGE_503;

        boolean auth = FTPTransferParametrs.AuthorizationChecker.isValidUser(login, passowrd);

        if (!auth) {
            return Reply.REPLY_MESSAGE_530;
        } else {
            ftpParametrs.setRootDir(login);
            ftpParametrs.setCurDirPath(login);
            ftpParametrs.setAuthorization(true);
            return String.format(Reply.REPLY_MESSAGE_230, login);
        }
    }
}

