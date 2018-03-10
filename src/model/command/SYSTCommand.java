package model.command;

import model.reply.Reply;

public final class SYSTCommand implements Command {


    @Override
    public String execute() {
        return String.format(Reply.REPLY_MESSAGE_230,
                System.getProperty("os.name"), System.getProperty("os.version"));
    }
}
