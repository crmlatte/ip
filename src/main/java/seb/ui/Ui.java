package seb.ui;
import java.util.ArrayList;

public class Ui {

    public Ui() {}

    /**
     * Welcome message printed when Sebastian runs
     */
    public void welcome() {
        System.out.println("Hello! My name is Sebastian~\nHow can I help you? :)");
    }

    /**
     * Exit message printed for command-line input "bye"
     */
    public void bye() {
        System.out.println("Bye! See you again :D");
    }

    /**
     * Prints all tasks stored in ArrayList
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

    /**
     * Prints all tasks on given date
     * @param dateInput String input of date, no time
     * @throws SebException for incorrect date format
     */
    public void showDates(ArrayList<Task> tasks, String dateInput) throws SebException {
        // in E, dd MMM yyyy format
        ArrayList<Task> matchingDates = new ArrayList<>();
        for (Task task : tasks) {
            // cut out time to compare date in E
            if (task.getDate().isEmpty()) {
                continue;
            }
            String date = task.getDate().substring(0, task.getDate().lastIndexOf(" "));
            if (dateInput.equals(date)) {
                matchingDates.add(task);
            }
        }
        if (matchingDates.isEmpty()) {
            System.out.println("Yay! You have no tasks on " + dateInput);
        } else {
            System.out.println("You have " + matchingDates.size() + " tasks on " + dateInput);
            int counter = 1;
            for (int i = 0; i < matchingDates.size(); i++) {
                System.out.println(counter + ". " + matchingDates.get(i).toString());
                counter++;
            }
        }
    }

    /**
     * Prints all tasks with matching description with input String
     * @param tasks ArrayList tasks
     * @param search String of keyword to match
     */
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
