package seb.ui;

public class Command {

    private String args;
    private String command;

    public Command(String command, String args) {
        this.command = command;
        this.args = args;
    }

    public String getCommand() {
        return this.command.toUpperCase();
    }

    public String getArgs() {
        return this.args;
    }
}
