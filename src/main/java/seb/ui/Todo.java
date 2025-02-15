package seb.ui;
public class Todo extends Task {

    public Todo(String desc, boolean isDone) {
        super(desc, isDone);
    }

    /**
     * Converts Todo object to String to be stored in data file
     *
     * @return String of event details
     */
    @Override
    public String getDate() {
        return "";
    }

    @Override
    public String toFileFormat() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
