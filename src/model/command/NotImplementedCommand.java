package model.command;

import model.reply.Reply;

public class NotImplementedCommand implements Command {


    @Override
    public String execute() {
        return Reply.REPLY_MESSAGE_502;
    }
}
