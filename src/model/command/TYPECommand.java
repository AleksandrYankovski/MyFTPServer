package model.command;

import model.reply.Reply;
import model.server.DataType;
import model.server.FTPServerDTP;

public final class TYPECommand implements Command {

    private String fileType;
    private FTPServerDTP ftpServerDTP;


    public TYPECommand(String fileType, FTPServerDTP ftpServerDTP) {
        this.fileType = fileType;
        this.ftpServerDTP = ftpServerDTP;
    }


    @Override
    public String execute() {
        String[] params = fileType.split(" ");

        switch (params[0]) {
            case "A":
                ftpServerDTP.getParametrs().setType(DataType.ASCII);
                if (params.length > 1)
                    ftpServerDTP.getParametrs().setFormatControlBySymbol(params[1]);
                break;
            case "E":
                ftpServerDTP.getParametrs().setType(DataType.EBCDIC);
                if (params.length > 1)
                    ftpServerDTP.getParametrs().setFormatControlBySymbol(params[1]);
                break;
            case "I":
                ftpServerDTP.getParametrs().setType(DataType.IMAGE);
                break;
            case "L":
                ftpServerDTP.getParametrs().setType(DataType.LOCAL);
                break;
            default:
                return Reply.REPLY_MESSAGE_504;
        }

        return Reply.REPLY_MESSAGE_200;

    }
}
