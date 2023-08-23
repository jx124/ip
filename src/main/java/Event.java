/**
 * Represents a Task with a start and end date.
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Constructor for an Event instance.
     *
     * @param description The description of the underlying task.
     * @param from The date on which the event begins.
     * @param to The date on which the event ends.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Provides the string representation of the Event instance.
     * @return A string with the relevant information of the Event task.
     */
    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.from, this.to);
    }
}
