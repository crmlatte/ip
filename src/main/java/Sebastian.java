import java.util.Scanner;
public class Sebastian {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("     --------------------------\n"
        + "     Hello! I'm Sebastian~ \n"
        + "     What can I do for you?\n"
        + "     --------------------------");
        String input = s.nextLine();
        while (!input.toUpperCase().equals("BYE")) {
            System.out.println("     --------------------------\n"
                    + "     "
                    + input + "\n     --------------------------");
            input = s.nextLine();
        }
        if (input.toUpperCase().equals("BYE")) {
            System.out.println("     --------------------------\n"
                    + "     Bye! See you again :D\n"
                    + "     --------------------------\n");
        }

    }
}
