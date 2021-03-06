package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.response.Response;
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
     * Executes the command, deleting a task from the given TaskList.
     *
     * @param taskList A TaskList instance.
     * @param storage A Storage instance.
     * @throws DukeException if the task cannot be found.
     */
    @Override
    public Response execute(TaskList taskList, Storage storage) throws DukeException {
        Task task = taskList.deleteTask(this.taskNo);
        Response response = new Response("Noted. I've removed this task:\n  "
                + task + "\n"
                + "Now you have " + taskList.getTasks().size()
                + (taskList.getTasks().size() == 1 ? " task" : " tasks") + " in the list.");
        storage.save(taskList.getTasks());

        return response;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeleteCommand) {
            return this.taskNo == ((DeleteCommand) obj).taskNo;
        }

        return false;
    }
}
