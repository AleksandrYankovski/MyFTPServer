package model.server;

import model.server.connection.ConnectionType;

import java.net.InetSocketAddress;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class FTPTransferParametrs {

    private String password;
    private String login;
    private String rootDirPath;
    private String curDirPath;
    private boolean authorization;
    private DataType typeTransfer;
    private FormatControl formatControl;
    private ConnectionType connectionType;
    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("resources//ftp");

    FTPTransferParametrs() {
        password = "";
        login = "";
        rootDirPath = "/";
        curDirPath = "/";
        authorization = false;
        typeTransfer = DataType.ASCII;
        formatControl = FormatControl.NON_PRINT;
    }


    public void setPassword(String password) {

        this.password = RESOURCE_BUNDLE.getString("ftp.password." + password);
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRootDir(String login) {
        this.rootDirPath = RESOURCE_BUNDLE.getString("ftp.root." + login);
    }

    public void setCurDirPath(String login) {
        this.curDirPath = RESOURCE_BUNDLE.getString(("ftp.root." + login));
    }

    public void setAuthorization(boolean authorization) {
        this.authorization = authorization;
    }

    public void setType(DataType typeTransfer) {
        this.typeTransfer = typeTransfer;
    }

    public void setFormatControl(FormatControl formatControl) {
        this.formatControl = formatControl;
    }

    public void setFormatControlBySymbol(String param) {

        if (("T".equalsIgnoreCase(param))) {
            setFormatControl(FormatControl.TELNET);
        } else {
            setFormatControl(FormatControl.CARRIAGE);
        }
    }


    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getRootDir() {
        return rootDirPath;
    }

    public String getCurDirPath() {
        return curDirPath;
    }

    public boolean isAuthorization() {
        return authorization;
    }

    public DataType getType() {
        return typeTransfer;
    }


    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public static class AuthorizationChecker {

        public static boolean isValidUser(String login, String verifiablePassword) {
            if (login != null && verifiablePassword.equals(RESOURCE_BUNDLE.getString("ftp.password." + login)))
                return true;
            return false;
        }
    }
}
