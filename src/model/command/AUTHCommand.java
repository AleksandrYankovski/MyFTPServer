package model.command;

import model.reply.Reply;

public final class AUTHCommand implements Command {


    @Override
    public String execute() {
        return Reply.REPLY_MESSAGE_502;
    }
}
