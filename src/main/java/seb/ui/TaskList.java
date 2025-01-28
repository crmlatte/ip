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

    /**
     * Adds task to ArrayList<Task>
     * @param t task to be added
     * @throws SebException if task is invalid
     */
    public void addTask(Task t) throws SebException {
        tasks.add(t);
    }

    /**
     * Remove task from ArrayList<Task>
     * @param i index of task to be removed from ArrayList<Task>
     * @throws IndexOutOfBoundsException if index entered is exceeding number of
     * items in list or < 0
     */
    public void removeTask(int i) throws IndexOutOfBoundsException {
        tasks.remove(i);
    }

    /**
     * Returns number of items in ArrayList<Task>
     * @return integer number
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Returns Task object from ArrayList<Task>
     * @param i index of Task to be obtained
     * @return Task
     * @throws IndexOutOfBoundsException for invalid index
     */
    public Task getTask(int i) throws IndexOutOfBoundsException {
        return tasks.get(i);
    }

    /**
     * Returns ArrayList<Task> of entire task list
     * @return ArrayList<Task>
     */
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
