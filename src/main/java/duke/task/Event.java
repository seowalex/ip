package duke.task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDateTime at;

    public Event(String description, LocalDateTime at) {
        this(description, at, false);
    }

    public Event(String description, LocalDateTime at, boolean isDone) {
        super(description, isDone);
        this.at = at;
    }

    @Override
    public boolean isDue(LocalDate date) {
        return at.toLocalDate().equals(date);
    }

    @Override
    public String toSaveData() {
        return "E | " + super.toSaveData() + " | " + at;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy, h:mm a");

        return "[E]" + super.toString() + " (at: " + at.format(formatter) + ")";
    }
}