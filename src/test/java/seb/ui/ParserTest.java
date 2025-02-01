package seb.ui;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    public void testParseTodo() throws SebException {
        String input = "Buy milk";
        assertEquals("Buy milk", Parser.parseTodo(input));
    }

    @Test
    public void testParseDeadline() throws SebException {
        String input = "Submit report/ 2025-02-10";
        String[] result = Parser.parseDeadline(input);
        assertEquals("Submit report", result[0]);
        assertEquals("2025-02-10", result[1]);
    }

    @Test
    public void testParseEvent() throws SebException {
        String input = "Meeting/ 10am / 12pm";
        String[] result = Parser.parseEvent(input);
        assertEquals("Meeting", result[0]);
        assertEquals("10am", result[1]);
        assertEquals("12pm", result[2]);
    }
}

