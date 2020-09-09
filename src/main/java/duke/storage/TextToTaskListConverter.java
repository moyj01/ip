package duke.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import duke.tasks.TaskList;

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
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            TaskList taskList = (TaskList) objectInputStream.readObject();
            objectInputStream.close();
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
