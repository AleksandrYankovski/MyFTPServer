package model;

import model.command.*;
import model.server.FTPServerDTP;

import java.nio.channels.SocketChannel;
import java.util.ResourceBundle;

public final class CommandCreator {


    private static Filter filter;


    public static Command getCommand(final String commandString, FTPServerDTP ftpServerDTP) {

        filter = new Filter(commandString);

        switch (filter.getCommandName()) {
            case "AUTH":
                return new AUTHCommand();
            case "USER":
                return new USERCommand(filter.getCommandParam(), ftpServerDTP);
            case "PASS":

                return new PASSCommand(filter.getCommandParam(), ftpServerDTP);
            case "SYST":
                return new SYSTCommand();
            case "PWD":
                return new PWDCommand(ftpServerDTP);
            case "FEAT":
                return new FEATCommand();
            case "TYPE":
                return new TYPECommand(filter.getCommandParam(), ftpServerDTP);
            case "PASV":
                return new PASVCommand(ftpServerDTP);
            case "PORT":
                return new PORTCommand(filter.getCommandParam(), ftpServerDTP);
            default:
                return new NotImplementedCommand();
        }
    }

    static class Filter {
        private String commandString;

        public Filter(String commandString) {
            this.commandString = commandString;
        }

        public String getCommandName() {

            return commandString.indexOf(' ') != -1 ?
                    commandString.substring(0, commandString.indexOf(' ')) : commandString;
        }

        public String getCommandParam() {

            return commandString.indexOf(' ') != -1 ?
                    commandString.substring(commandString.indexOf(' ') + 1) : null;
        }
    }
}
