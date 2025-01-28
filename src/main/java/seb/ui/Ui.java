package seb.ui;

import java.util.ArrayList;

public class Ui {

    public Ui() {}

    public void welcome() {
        System.out.println("Hello! My name is Sebastian~\nHow can i help you? :)");
    }

    public void bye() {
        System.out.println("Bye! See you again :D");
    }

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

    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    public void showSuccess(String message) {
        System.out.println(message);
    }


}
