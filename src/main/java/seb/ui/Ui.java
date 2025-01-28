package seb.ui;

import java.util.ArrayList;

public class Ui {

    public Ui() {}

    /**
     * Welcome message printed when Sebastian runs
     */
    public void welcome() {
        System.out.println("----------------------------------------------");
        System.out.println("Hello! My name is Sebastian~\nHow can i help you? :)");
        System.out.println("----------------------------------------------");
    }

    /**
     * Exit message printed for command-line input "bye"
     */
    public void bye() {
        System.out.println("----------------------------------------------");
        System.out.println("Bye! See you again :D");
        System.out.println("----------------------------------------------");
    }

    /**
     * Prints all tasks stored in ArrayList<Task>
     * @param tasks list of all tasks
     */
    public void list(ArrayList<Task> tasks) {
        System.out.println("----------------------------------------------");
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
        System.out.println("----------------------------------------------");
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
}
