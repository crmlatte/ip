import java.util.ArrayList;
import java.util.Scanner;
public class Sebastian {
    static final String NEWLINE = "     --------------------------";
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] store = new String[100]; // store the input in array

        // welcome msg
        System.out.println(NEWLINE
        + "\n     Hello! I'm Sebastian~ "
        + "\n     What can I do for you?\n"
        + NEWLINE);

        String input = s.nextLine();
        int count = 0; // array indexing
        while (!input.toUpperCase().equals("BYE")) {
            System.out.println(NEWLINE);

            // if ask for list --> "list" word not saved in list
            if (input.toUpperCase().equals("LIST")) {
                System.out.println("     Here is your list:");
                int i = 0;
                while (!(store[i] == null)) {
                    System.out.println("     " + (i + 1) + ". " + store[i]);
                    i++;
                }

            } else {
                store[count] = input;
                System.out.println("     "
                        + "You have added: "
                        + input);
                count++;
            }
            System.out.println(NEWLINE);
            input = s.nextLine();
        }

        // Exit
        if (input.toUpperCase().equals("BYE")) {
            System.out.println(NEWLINE
                    + "\n     Bye! See you again :D\n"
                    + NEWLINE);
        }

    }
}
