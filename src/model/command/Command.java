package model.command;

import model.reply.Reply;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface Command {


     String execute() throws IOException, ExecutionException, InterruptedException;
}
