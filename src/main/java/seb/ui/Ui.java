package seb.ui;
import java.util.ArrayList;

public class Ui {

    public Ui() {}

    /**
     * Welcome message printed when Sebastian runs
     */
    public void welcome() {
        System.out.println("Hello! My name is Sebastian~\nHow can i help you? :)");
    }

    /**
     * Exit message printed for command-line input "bye"
     */
    public void bye() {
        System.out.println("Bye! See you again :D");
    }

    /**
     * Prints all tasks stored in ArrayList<Task>
     * @param tasks list of all tasks
     */
    public void list(ArrayList<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("Your list is empty. Please add some tasks!");
        } else {
            System.out.println("Here is your list:");
            int counter = 1;
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println(counter + ". " + tasks.get(i).toString());
                counter++;
            }
        }
    }

    /**
     * Prints error message from exceptions thrown
     * @param message String message from exceptions
     */
    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showSuccess(String message) {
        System.out.println(message);
    }

    public void find(ArrayList<Task> tasks, String search) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getDescription().contains(search)) {
                matchingTasks.add(tasks.get(i));
            }
        }
        if (matchingTasks.isEmpty()) {
            System.out.println("There are no matching tasks.");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            int counter = 1;
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println(counter + ". " + matchingTasks.get(i).toString());
                counter++;
            }
        }
    }
}
