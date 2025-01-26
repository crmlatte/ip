public class Event extends Task {
    private String description;
    private boolean status;
    private String start;
    private String end;

    public Event(String description, String start, String end) {
        super(description);
        this.status = false;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.start + " to: "
                + this.end + ")";
    }
}
