package seb.ui;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {

    public static Command parse(String input) throws SebException {
        if (input.isEmpty()) {
            throw new SebException("Please enter something!");
        }
        String[] parts = input.split(" ", 2);
        String command = parts[0].trim();

        if (parts.length == 1) {
            return new Command(command, "");
        } else {
            return new Command(command, parts[1].trim());
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
        for (String s : parts) {
            s.trim();
        }
        return parts;
    }

    public static String[] parseEvent(String input) throws SebException{
        String[] parts = input.split("/", 4);
        if (parts.length != 3) {
            throw new SebException("Invalid Event format. Please use: event [name] /[from] /[to]");
        }
        for (String s : parts) {
            s.trim();
        }
        return parts;
    }

    public static int parseNum(String input) {
        return Integer.parseInt(input);
    }

    public static String parseDateTime(String input) throws SebException {
        try {
            DateTimeFormatter formatInput = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmm");
            LocalDateTime dateTime = LocalDateTime.parse(input, formatInput);
            DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm");
            String formattedDT = dateTime.format(formatOutput);
            return formattedDT;
        } catch (DateTimeParseException e) {
            throw new SebException("Invalid date-time format! Please use dd-mm-yyyy HHmm");
        }
    }

    public static String parseShowDate(String input) throws SebException {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dateTime = LocalDate.parse(input, formatter);
            DateTimeFormatter formatOutput = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
            String ftd = dateTime.format(formatOutput);
            return ftd;
        } catch (DateTimeParseException e) {
            throw new SebException("Invalid date-time format! Please use dd-mm-yyyy");
        }
    }
}
