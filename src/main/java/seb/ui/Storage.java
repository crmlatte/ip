package seb.ui;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    private final String filePath;

    public Storage(String filepath) {
        assert filepath != null : "Filepath cannot be null!";

        this.filePath = filepath;
    }

    /**
     * Loads tasks from the file into ArrayList
     * Creates the file and directory if they don't exit
     * @return tasks in an ArrayList
     */
    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                // create directory if file dont exist
                file.getParentFile().mkdirs();
                file.createNewFile();
                return tasks;
            }
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" \\| ");
                String taskType = parts[0];
                boolean isDone = parts[1].equals("1");
                String description = parts[2];

                switch (taskType) {
                case "T":
                    tasks.add(new Todo(description, isDone));
                    break;
                case "D":
                    String due = parts[3];
                    tasks.add(new Deadline(description, due, isDone));
                    break;
                case "E":
                    String start = parts[3];
                    String end = parts[4];
                    tasks.add(new Event(description, start, end, isDone));
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return tasks;
    }

    public void saveTasks(ArrayList<Task> tasks) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Task t : tasks) {
                writer.println(t.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}
