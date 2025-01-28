package seb.ui;

public class Parser {

    /**
     * Parses command-line input into "command" and "args"
     * eg "deadline" + "quiz 3/12-01-2025 1600"
     * @param input String input from command-line
     * @return Command object containing a Command string and Args string
     * @throws SebException if command-line input is empty
     */
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

    /**
     * Returns a String that checks if Todo input is an empty tasj
     * @param input Args of the Command (description of todo)
     * @return String description of todo
     * @throws SebException if todo description is empty
     */
    public static String parseTodo(String input) throws SebException {
        if (input.isEmpty()) {
            throw new SebException("Description cannot be empty!");
        }
        return input;
    }

    /**
     * Returns a String array containing elements of Deadline object
     * eg [description, deadline] split from Args from Command
     * @param input Args of the Command
     * @return String array
     * @throws SebException if format of deadline is incorrect
     */
    public static String[] parseDeadline(String input) throws SebException{
        String[] parts = input.split("/", 4);
        if (parts.length != 2) {
            throw new SebException("Invalid Deadline format. Please use: deadline [name] /[by when]");
        }
        return parts;
    }

    /**
     * Returns a String array containing elements of Event object
     * eg [description, start, end] split from Args from Command
     * @param input Args of Command object
     * @return String array
     * @throws SebException if format of event is incorrect
     */
    public static String[] parseEvent(String input) throws SebException{
        String[] parts = input.split("/", 4);
        if (parts.length != 3) {
            throw new SebException("Invalid Event format. Please use: event [name] /[from] /[to]");
        }
        return parts;
    }

    /**
     * Returns an integer from command line String input eg "mark 3"
     * will return (int) 3
     * @param input Args of Command object
     * @return integer value of String number
     */
    public static int parseNum(String input) {
        return Integer.parseInt(input);
    }
}
