package seb.ui;
public class Todo extends Task {

    public Todo(String desc, boolean isDone) {
        super(desc, isDone);
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
