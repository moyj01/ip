package duke.command;

import duke.exceptions.DukeException;
import duke.tasks.Deadline;
import duke.tasks.Task;
import duke.tasks.TaskList;
import duke.timeformatter.TimeFormatter;
import duke.ui.Ui;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a command that adds a deadline task.
 */
public class DeadlineCommand extends UserCommand {

    /**
     * @param userInput user's input.
     */
    public DeadlineCommand(String userInput) {
        super(userInput);
    }

    /**
     * @param taskList task list containing all the tasks.
     * @param ui       ui that prints output.
     * @throws DukeException
     */
    @Override
    public void execute(TaskList taskList, Ui ui) throws DukeException {

        List<Task> ls = taskList.getTasks();
        String[] deadlineArr = userInput.split("/", 2);
        String by = deadlineArr[1].substring(deadlineArr[1].indexOf("by") + 3);
        String deadlineString = deadlineArr[0].substring(9);
        LocalDate localDeadlineDate = TimeFormatter.localDate(by);
        Deadline deadline = new Deadline(deadlineString, localDeadlineDate);
        ls.add(deadline);
        System.out.println("Got it. I've added this task:");
        System.out.println(deadline.toString());
        System.out.format("Now you have %d tasks in the list\n", ls.size());
    }
}
