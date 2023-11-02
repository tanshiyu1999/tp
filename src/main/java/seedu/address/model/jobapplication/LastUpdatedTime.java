package seedu.address.model.jobapplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import seedu.address.commons.exceptions.IllegalValueException;

/**
 * The latest time that the job application was updated.
 * Completely immutable, users are not able to specify the updated time.
 */
public class LastUpdatedTime implements Comparable<LastUpdatedTime> {

    private static final String INVALID_FORMAT_MESSAGE = "The given last modified datetime is invalid: %s\n Delete "
            + "the last updated time section to reset the last updated time.";

    private static final DateTimeFormatter displayFormat =
            DateTimeFormatter.ofPattern(
                    "dd-MM-yyyy h:mma",
                    Locale.ENGLISH
            );

    public final LocalDateTime lastUpdatedTime;

    /**
     * Constructs an autogenerated {@code LastUpdatedTime}
     */
    public LastUpdatedTime() {
        this.lastUpdatedTime = LocalDateTime.now();
    }

    /**
     * Constructs a {@code LastUpdatedTime} for testing purposes only.
     * @param dateTime of the updated time.
     */
    public LastUpdatedTime(LocalDateTime dateTime) {
        this.lastUpdatedTime = dateTime;
    }

    /**
     * Generates a {@code LastUpdatedTime} for the purpose of storage.
     */
    public static LastUpdatedTime generateLastUpdatedTime(String test) throws IllegalValueException {
        try {
            return new LastUpdatedTime(
                    LocalDateTime.parse(test)
            );
        } catch (DateTimeParseException e) {
            throw new IllegalValueException(String.format(INVALID_FORMAT_MESSAGE, test));
        }
    }

    public String toDisplayString() {
        return lastUpdatedTime.format(displayFormat);
    }

    @Override
    public String toString() {
        return lastUpdatedTime.toString();
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof LastUpdatedTime)) {
            return false;
        }

        LastUpdatedTime otherLastUpdate = (LastUpdatedTime) other;
        return lastUpdatedTime.equals(otherLastUpdate.lastUpdatedTime);
    }

    @Override
    public int compareTo(LastUpdatedTime o) {
        return this.lastUpdatedTime.compareTo(o.lastUpdatedTime);
    }
}
