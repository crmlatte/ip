package seb.ui;

public class Deadline extends Task {

    private String deadLine;

    public Deadline(String description, String deadLine, boolean isDone) {
        super(description, isDone);
        this.deadLine = deadLine;
    }

    @Override
    public String toFileFormat() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + this.deadLine;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadLine + ")";
    }
}
