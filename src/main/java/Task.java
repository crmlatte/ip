import java.util.ArrayList;

public class Task {

    private String description;
    //private Task[] store = new Task[100]; // i think put in Seb class?
    // then list() will also be in Seb class?
    private boolean status;

    public Task(String description) {
        this.description = description;
        this.status = false;
    }

    public void markDone() {
        this.status = true;
    }

    public void markNotDone() {
        this.status = false;
    }

    @Override
    public String toString() {
        return (this.status ? "[X]" : "[ ]") +  " " + this.description;
    }
}
