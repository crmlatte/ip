package seb.ui;
import java.util.ArrayList;

public abstract class Task {

    protected String description;
    protected boolean isDone;

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markNotDone() {
        this.isDone = false;
    }

    public abstract String toFileFormat();

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return (this.isDone ? "[X]" : "[ ]") +  " " + this.description;
    }
}
