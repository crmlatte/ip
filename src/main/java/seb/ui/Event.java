package seb.ui;

public class Event extends Task {

    private String start;
    private String end;

    public Event(String description, String start, String end, boolean isDone) {
        super(description, isDone);
        this.start = start;
        this.end = end;
    }

    /**
     * Converts Event object to String to be stored in data file
     *
     * @return String of event details
     */
    @Override
    public String getDate() {
        return this.start;
    }

    /**
     * Update description, start time or end time of event task
     *
     * @param detail the attribute of event to be edited
     * @param value the new attribute
     * @throws SebException for invalid input
     */
    @Override
    public void update(String detail, String value) throws SebException {
        if (detail.contains("desc")) {
            this.description = value;
        } else if (detail.contains("start")) {
            this.start = Parser.parseDateTime(value);
        } else if (detail.contains("end")) {
            this.end = Parser.parseDateTime(value);
        } else {
            throw new SebException("Invalid format!");
        }
    }

    @Override
    public String toFileFormat() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + this.start + " | " + this.end;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + this.start + " to: "
                + this.end + ")";
    }
}
