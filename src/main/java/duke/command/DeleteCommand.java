package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.Ui;
import duke.task.Task;

/**
 * Represents a delete command.
 */
public class DeleteCommand extends Command {
    private final int taskNo;

    public DeleteCommand(int taskNo) {
        this.taskNo = taskNo;
    }

    /**
     * Executes the command, deleting a task from the provided TaskList.
     *
     * @param taskList TaskList instance
     * @param ui Ui instance
     * @param storage Storage instance
     * @throws DukeException if the task cannot be found.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Task task = taskList.deleteTask(this.taskNo);
        ui.showPrompt("Noted. I've removed this task:\n  "
                + task + "\n" + "Now you have " + taskList.getTasks().size()
                + (taskList.getTasks().size() == 1 ? " task" : " tasks") + " in the list.");
    }
}
