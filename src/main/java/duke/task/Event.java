package duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents an event.
 */
public class Event extends Task {
    private final LocalDateTime at;

    public Event(String description, LocalDateTime at) {
        this(description, at, false);
    }

    /**
     * The event constructor.
     *
     * @param description The description of the event.
     * @param at The date/time the event is due by.
     * @param isDone The boolean keeping track of whether the event is done.
     */
    public Event(String description, LocalDateTime at, boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    /**
     * Returns a boolean indicating if the event is happening at the given date.
     *
     * @param date A date.
     * @return true if the event is happening at the given date.
     */
    @Override
    public boolean isDue(LocalDate date) {
        return this.at.toLocalDate().equals(date);
    }

    @Override
    public String toSaveData() {
        return "E | " + super.toSaveData() + " | " + this.at;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy, h:mm a");

        return "[E]" + super.toString() + " (at: " + this.at.format(formatter) + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Event) {
            return super.equals(obj) && this.at.equals(((Event) obj).at);
        }

        return false;
    }
}
