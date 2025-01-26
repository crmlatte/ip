import java.util.ArrayList;
import java.util.Scanner;
public class Sebastian {
    static final String NEWLINE = "     --------------------------";
    private static ArrayList<Task> store = new ArrayList<>(); // store tasks in the list
    //String[] store = new String[100]; // store the input in array

    public String list() {
        String s = "     Here is your list:";
        int counter = 1;
        for (Task t : this.store) {
            s += "\n     " + counter + ". " + t.toString();
            counter++;
        }
        return s;
    }

    public static void main(String[] args) {
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

            } else if (command.equals("ADD")){
                Task tt = new Task(arg);
                store.add(tt);
                System.out.println("     "
                        + "You have added:\n"
                        + "     "
                        + tt.toString());
            } else if (command.equals("MARK")) {
                int index = Integer.valueOf(arg) - 1;
                Task tt = store.get(index);
                tt.markDone();
                System.out.println(
                        "     Great job! You have completed:\n"
                        + "     "
                        + tt.toString()
                );
            } else if (command.equals("UNMARK")) {
                int index = Integer.valueOf(arg) - 1;
                Task tt = store.get(index);
                tt.markNotDone();
                System.out.println(
                        "     Ok, I've marked this task as not done:\n"
                                + "     "
                        + tt.toString()
                );
            }
            System.out.println(NEWLINE);
        }

    }
}
