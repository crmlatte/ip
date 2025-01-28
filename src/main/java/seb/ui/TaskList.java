package seb.ui;
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
}
