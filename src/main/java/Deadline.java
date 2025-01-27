public class Deadline extends Task {

    private String description;
    private boolean status;
    private String deadline;
    private boolean swit = false;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
        this.status = false;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.deadline + ")";
    }
}
