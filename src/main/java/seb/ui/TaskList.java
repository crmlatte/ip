package seb.ui;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class TaskList {

    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task t) throws SebException {
        tasks.add(t);
    }

    public void removeTask(int i) throws IndexOutOfBoundsException {
        tasks.remove(i);
    }

    public int size() {
        return tasks.size();
    }

    public Task getTask(int i) throws IndexOutOfBoundsException {
        return tasks.get(i);
    }

    public ArrayList<Task> getTaskList() {
        return tasks;
    }

    public void showDates(String dateTime) throws SebException {
        // in E, dd MMM yyyy format
        System.out.println("You have these tasks on " + dateTime);
        for (Task task : tasks) {
            // cut out time to compare date in E
            if (task.getDate().isEmpty()) {
                continue;
            }
            String date = task.getDate().substring(0, task.getDate().lastIndexOf(" "));
            if (dateTime.equals(date)) {
                System.out.println(task.toString());
            }
        }
    }
}
