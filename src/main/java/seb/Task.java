package seb;
import java.util.ArrayList;

public abstract class Task {

    protected String description;
    //private Task[] store = new Task[100]; // i think put in Seb class?
    // then list() will also be in Seb class?
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

    @Override
    public String toString() {
        return (this.isDone ? "[X]" : "[ ]") +  " " + this.description;
    }
}
