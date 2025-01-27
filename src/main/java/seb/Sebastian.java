package seb;
import java.util.ArrayList;
import java.util.Scanner;
public class Sebastian {
    static final String NEWLINE = "     --------------------------";
    private static final String FILEPATH = "./data/Sebastian.txt";
    private static Storage storage;
    private static ArrayList<Task> store = new ArrayList<>(); // store tasks in the list
    //String[] store = new String[100]; // store the input in array

    public Sebastian() {
        storage = new Storage(FILEPATH);
        store = storage.loadTasks();
    }
    public String list() {
        String s = "     Here is your list:";
        if (store.size() == 0) {
            s = "     Your list is empty. Add some tasks!";
        }
        int counter = 1;
        for (Task t : this.store) {
            s += "\n     " + counter + ". " + t.toString();
            counter++;
        }
        return s;
    }

    public static void main(String[] args) throws SebException {
        Scanner s = new Scanner(System.in);

        // welcome msg
        System.out.println(NEWLINE
        + "\n     Hello! I'm Sebastian~ "
        + "\n     What can I do for you?\n"
        + NEWLINE);

        Sebastian seb = new Sebastian();

        while (true) {
            String input = s.nextLine();
            String[] parts = input.split(" ", 2);
            String command = parts[0].toUpperCase();
            String arg = parts.length > 1 ? parts[1] : "";

            System.out.println(NEWLINE);

            if (command.equals("BYE")) {
                System.out.println("     Bye! See you again :D\n"
                + NEWLINE);
                break;
            } else if (command.equals("LIST")) {
                System.out.println(seb.list());

            } else if (command.equals("TODO")){
                if (arg.isEmpty()) {
                    throw new SebException("Oops! Description cannot be empty");
                }
                Task tt = new Todo(arg, false);
                store.add(tt);
                storage.saveTasks(store);
                System.out.println("     "
                        + "You have added the task:\n"
                        + "       "
                        + tt.toString());
                System.out.println("     Now you have " + store.size()
                + " items in your list.");
            } else if (command.equals("DEADLINE")) {
                String[] sp = arg.split("/", 2);
                if (sp.length < 2 || sp[0].isEmpty() || sp[1].isEmpty()) {
                    throw new SebException("Oops! Wrong Deadline format. Please use: deadline [name] /[by when]");
                }
                Task tt = new Deadline(sp[0], sp[1], false);
                store.add(tt);
                storage.saveTasks(store);
                System.out.println("     "
                        + "You have added the deadline:\n"
                        + "       "
                        + tt.toString());
                System.out.println("     Now you have " + store.size()
                        + " items in your list.");
            } else if (command.equals("EVENT")) {
                String[] sp = arg.split("/", 3);
                if (sp.length < 3) {
                    throw new SebException("Oops! Wrong Event format. Please use: event [name] /[from] /[to]");
                }
                Task tt = new Event(sp[0], sp[1], sp[2], false);
                store.add(tt);
                storage.saveTasks(store);
                System.out.println("     "
                        + "You have added the event:\n"
                        + "       "
                        + tt.toString());
                System.out.println("     Now you have " + store.size()
                        + " items in your list.");
            } else if (command.equals("MARK")) {
                int index = Integer.valueOf(arg) - 1;
                if (index >= store.size() || index < 0) {
                    throw new SebException("Oops! There are only " + store.size()
                            + " tasks.");
                }
                Task tt = store.get(index);
                tt.markDone();
                storage.saveTasks(store);
                System.out.println(
                        "     Great job! You have completed:\n"
                        + "     "
                        + tt.toString()
                );
            } else if (command.equals("UNMARK")) {
                int index = Integer.valueOf(arg) - 1;
                if (index >= store.size() || index < 0) {
                    throw new SebException("Oops! There are only " + store.size()
                    + " tasks.");
                }
                Task tt = store.get(index);
                tt.markNotDone();
                storage.saveTasks(store);
                System.out.println(
                        "     Ok, I've marked this task as not done:\n"
                                + "     "
                        + tt.toString()
                );
            } else if (command.equals("DELETE")) {
                int index = Integer.valueOf(arg) - 1;
                Task tt = store.get(index);
                store.remove(index);
                storage.saveTasks(store);
                System.out.println("     Ok, I've removed this task:\n"
                + "     " + tt.toString());
                System.out.println("     Now you have " + store.size()
                        + " items in your list.");
            } else {
                throw new SebException("Sorry, I don't understand :(");
            }
            System.out.println(NEWLINE);
        }

    }
}
