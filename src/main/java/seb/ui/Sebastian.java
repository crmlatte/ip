package seb.ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sebastian {

    private static final String FILEPATH = "./data/Sebastian.txt";
    private static Storage storage;
    private Ui ui;
    private static TaskList tasks; // store tasks in the list

    public Sebastian(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        tasks = new TaskList(storage.loadTasks());
    }

    public void run() {
        ui.welcome();
        Scanner s = new Scanner(System.in);

        while (true) {
            String input = s.nextLine();

            try {
                Command command = Parser.parse(input);

                switch (command.getCommand()) {
                case "BYE":
                    ui.bye();
                    return;

                case "LIST":
                    ui.list(tasks.getTaskList());
                    break;

                case "TODO":
                    String desc = Parser.parseTodo(command.getArgs());
                    tasks.addTask(new Todo(desc, false));
                    storage.saveTasks(tasks.getTaskList());
                    ui.showSuccess("You have successfully added task: " + desc);
                    break;

                case "DEADLINE":
                    String[] parts = Parser.parseDeadline(command.getArgs());
                    tasks.addTask(new Deadline(parts[0], parts[1], false));
                    storage.saveTasks(tasks.getTaskList());
                    ui.showSuccess("You have successfully added deadline: " + parts[0]);
                    break;

                case "EVENT":
                    String[] parts2 = Parser.parseEvent(command.getArgs());
                    tasks.addTask(new Event(parts2[0], parts2[1], parts2[2], false));
                    storage.saveTasks(tasks.getTaskList());
                    ui.showSuccess("You have successfully added event: " + parts2[0]);
                    break;

                case "MARK":
                    int index = Parser.parseNum(command.getArgs()) - 1;
                    tasks.getTask(index).markDone();
                    storage.saveTasks(tasks.getTaskList());
                    ui.showSuccess("Great! You have completed: " + tasks.getTask(index).getDescription());
                    break;

                case "UNMARK":
                    int index2 = Parser.parseNum(command.getArgs()) - 1;
                    tasks.getTask(index2).markNotDone();
                    storage.saveTasks(tasks.getTaskList());
                    ui.showSuccess("Okay, you have yet to finish: " + tasks.getTask(index2).getDescription());
                    break;

                case "DELETE":
                    int index3 = Parser.parseNum(command.getArgs()) - 1;
                    Task deltask = tasks.getTask(index3);
                    tasks.removeTask(index3);
                    storage.saveTasks(tasks.getTaskList());
                    ui.showSuccess("You have deleted: " + deltask.getDescription());
                    break;

                default:
                    ui.showError("Sorry, I didn't understand that.");
                }
            } catch (Exception e) {
                ui.showError(e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) throws SebException {
        new Sebastian(FILEPATH).run();
    }
}
