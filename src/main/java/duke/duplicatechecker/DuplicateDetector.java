package duke.duplicatechecker;

import java.time.LocalDate;

import duke.tasks.Task;
import duke.tasks.TaskList;

public class DuplicateDetector {

    private String description;
    private LocalDate date;
    private TaskList taskList;
    private String taskType;

    public DuplicateDetector(String description, LocalDate date, TaskList taskList, String taskType) {
        this.description = description;
        this.date = date;
        this.taskList = taskList;
        this.taskType = taskType;
    }

    public DuplicateDetector(String description, TaskList taskList, String taskType) {
        this.description = description;
        this.taskList = taskList;
        this.date = null;
        this.taskType = taskType;
    }

    public boolean checkForDuplicates() {
        boolean hasDuplicate = false;
        for (int i = 0; i < taskList.listSize(); i++) {
            Task task = taskList.getTask(i);
            if (taskType.equals(task.getTaskType())) {
                String taskDescription = task.getDescription().toLowerCase();
                LocalDate localDate = task.getLocalDate();
                if (taskDescription.equals(description.toLowerCase()) && (localDate == null
                        || localDate.equals(date))) {
                    hasDuplicate = true;
                }
            }
        }
        return hasDuplicate;
    }

}
