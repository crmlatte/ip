package seb;

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
}
