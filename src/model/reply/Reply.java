package model.reply;

import java.util.HashMap;

public final class Reply {

    public static final String REPLY_MESSAGE_220 = "220 FTPServer  connect.\r\n";
    public static final String REPLY_MESSAGE_221 = "221 Service closing control connection.\r\n";
    public static final String REPLY_MESSAGE_150 = "150 File status okay; about to open data connection.\r\n";
    public static final String REPLY_MESSAGE_226 = "226 Succesfully transferred.\r\n";
    public static final String REPLY_MESSAGE_200 = "200 Command okay.\r\n";
    public static final String REPLY_MESSAGE_331 = "331 Password required for %s.\r\n";
    public static final String REPLY_MESSAGE_230 = "230 User %s logged in.\r\n";
    public static final String REPLY_MESSAGE_452 = "452 Requested action not taken.\r\n";
    public static final String REPLY_MESSAGE_450 = "450 Requested file action not taken.\r\n";
    public static final String REPLY_MESSAGE_250 = "250 Requested file action okay, completed.\r\n";
    public static final String REPLY_MESSAGE_501 = "501 Syntax error in parameters or arguments\r\n";
    public static final String REPLY_MESSAGE_502 = "502 did not implemented.\r\n";
    public static final String REPLY_MESSAGE_503 = "503 Bad sequence of commands.\r\n";
    public static final String REPLY_MESSAGE_530 = "530 Login incorrect.\r\n";
    public static final String REPLY_MESSAGE_215 = "215 OS name: %s OS version: %s.\r\n";
    public static final String REPLY_MESSAGE_257 = "257 %s is current directory.\r\n";
    public static final String REPLY_MESSAGE_211 = "211 command is not implement.\r\n";
    public static final String REPLY_MESSAGE_504 = "504 Command not implemented for that parameter.\r\n";
    public static final String REPLY_MESSAGE_227 = "227 Entering Passive Mode %s.\r\n";

}
