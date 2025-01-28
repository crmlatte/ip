package seb.ui;

public class Deadline extends Task {

    private String deadLine;

    public Deadline(String description, String deadLine, boolean isDone) {
        super(description, isDone);
        this.deadLine = deadLine;
    }

    /**
     * Converts Deadline object to String to be stored in data file
     * @return String of event details
     */
    @Override
    public String getDate() {
        return this.deadline;
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
