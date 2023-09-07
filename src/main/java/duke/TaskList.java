package duke;

import duke.task.Task;

import java.util.ArrayList;

/**
 * Class that represents a list of duke.task.Task instances to be stored.
 */
public class TaskList {
    private final ArrayList<Task> tasks;

    /**
     * Default constructor that returns an empty duke.TaskList instance.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Constructor that converts an ArrayList of duke.task.Tasks into an instance of duke.TaskList.
     *
     * @param tasks The corresponding ArrayList of Tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Add a new duke.task.Task to the end of the TaskList.
     *
     * @param task The Task to be added.
     */
    public void add(Task task) {
        this.tasks.add(task);
    }

    /**
     * Remove a duke.task.Task instance from the TaskList. Note that this method uses 1-based indexing in
     * correspondence with the index generated by the printList() method.
     *
     * @param index The index of the duke.task.Task instance to be removed.
     * @return The removed duke.task.Task instance.
     * @throws DukeException if the index provided is out of bounds.
     */
    public Task remove(int index) throws DukeException {
        if (index < 1 || index > tasks.size()) {
            throw new DukeException(Messages.MESSAGE_INVALID_INDEX);
        }

        return this.tasks.remove(index - 1);
    }

    public int size() {
        return this.tasks.size();
    }

    /**
     * Returns the string representation of the TaskList used by the duke.Storage class in the save files.
     *
     * @return A String of all duke.task.Task instances in the TaskList.
     */
    public String getSaveString() {
        StringBuilder tempString = new StringBuilder();
        for (Task task : this.tasks) {
            tempString.append(task.getSaveString()).append(System.lineSeparator());
        }

        return tempString.toString();
    }

    /**
     * Prints the duke.task.Task instances in the TaskList in a human-readable format.
     */
    public String printTasks() {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            tempString.append((i + 1))
                    .append(". ")
                    .append(this.tasks.get(i))
                    .append(System.lineSeparator());
        }
        return tempString.toString();
    }

    /**
     * Marks a specific duke.task.Task instance as done.
     *
     * @param index The index of the duke.task.Task instance.
     * @return The duke.task.Task instance marked as done.
     * @throws DukeException if the index provided is out of bounds.
     */
    public Task markAsDone(int index) throws DukeException {
        if (index < 1 || index > tasks.size()) {
            throw new DukeException(Messages.MESSAGE_INVALID_INDEX);
        }

        Task currentTask = this.tasks.get(index - 1);
        currentTask.markAsDone();
        return currentTask;
    }

    /**
     * Marks a specific duke.task.Task instance as undone.
     *
     * @param index The index of the duke.task.Task instance.
     * @return The duke.task.Task instance marked as undone.
     * @throws DukeException if the index provided is out of bounds.
     */
    public Task markAsUndone(int index) throws DukeException {
        if (index < 1 || index > tasks.size()) {
            throw new DukeException(Messages.MESSAGE_INVALID_INDEX);
        }

        Task currentTask = this.tasks.get(index - 1);
        currentTask.markAsUndone();
        return currentTask;
    }

    public String findTasks(String query) {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < this.tasks.size(); i++) {
            Task task = this.tasks.get(i);
            if (task.toString().contains(query)) {
                tempString.append(i + 1)
                        .append(". ")
                        .append(task)
                        .append(System.lineSeparator());
            }
        }

        return tempString.toString();
    }
}
