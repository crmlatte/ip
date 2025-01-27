package seb;

public class Parser {

    public static Command parse(String input) throws SebException {
        if (input.isEmpty()) {
            throw new SebException("Please enter something!");
        }
        String[] parts = input.split(" ", 2);
        String command = parts[0];

        if (parts.length == 1) {
            return new Command(command, "");
        } else {
            return new Command(command, parts[1]);
        }
    }

    public static String parseTodo(String input) throws SebException {
        if (input.isEmpty()) {
            throw new SebException("Description cannot be empty!");
        }
        return input;
    }

    public static String[] parseDeadline(String input) throws SebException{
        String[] parts = input.split("/", 4);
        if (parts.length != 2) {
            throw new SebException("Invalid Deadline format. Please use: deadline [name] /[by when]");
        }
        return parts;
    }

    public static String[] parseEvent(String input) throws SebException{
        String[] parts = input.split("/", 4);
        if (parts.length != 3) {
            throw new SebException("Invalid Event format. Please use: event [name] /[from] /[to]");
        }
        return parts;
    }

    public static int parseNum(String input) {
        return Integer.parseInt(input);
    }
}
