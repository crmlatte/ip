public class Todo extends Task {

    private String description;
    private boolean status;

    public Todo(String desc) {
        super(desc);
        this.status = false;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
