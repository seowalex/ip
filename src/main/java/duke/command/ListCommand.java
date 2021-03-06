package duke.command;

import java.util.List;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;
import duke.response.Response;
import duke.task.Task;

/**
 * Represents a list command.
 */
public class ListCommand extends Command {
    /**
     * Executes the command, listing all tasks.
     *
     * @param taskList A TaskList instance.
     * @param storage A Storage instance.
     * @throws DukeException if there are no tasks.
     */
    @Override
    public Response execute(TaskList taskList, Storage storage) throws DukeException {
        List<Task> tasks = taskList.getTasks();

        if (tasks.size() == 0) {
            throw new DukeException("There are no tasks in your list.");
        }

        StringBuilder output = new StringBuilder("Here are the tasks in your list:\n");

        for (Task task : tasks) {
            output.append(tasks.indexOf(task) + 1).append(".").append(task).append('\n');
        }

        return new Response(output.toString());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ListCommand;
    }
}
