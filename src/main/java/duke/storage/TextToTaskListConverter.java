package duke.storage;

import duke.tasks.Task;
import duke.tasks.TaskList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Converts txt file to an arraylist.
 */
public class TextToTaskListConverter {

    /**
     * @param filePath location of the file.
     * @return list containing the previously saved tasks.
     */
    public static TaskList readFile(String filePath) {
        try {
            FileInputStream readData = new FileInputStream(filePath);
            ObjectInputStream readStream = new ObjectInputStream(readData);
            TaskList taskList = (TaskList) readStream.readObject();
            readStream.close();
            return taskList;
        } catch (FileNotFoundException e) {
            System.out.println("File not found.Creating new save file");
            return new TaskList();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}