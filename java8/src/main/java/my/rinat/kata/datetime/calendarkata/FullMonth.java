package my.rinat.kata.datetime.calendarkata;

import java.time.LocalDate;

import org.eclipse.collections.api.multimap.sortedset.SortedSetMultimap;
import org.threeten.extra.LocalDateRange;

public class FullMonth extends CalendarWindow {
    /**
     * TODO Calculate the start, end and range of dates for the full month including the specified date.
     * <p>
     * Hint: Look at {@link LocalDate#withDayOfMonth(int)}
     * Hint: Look at {@link LocalDate#lengthOfMonth()}
     * Hint: Look at {@link LocalDateRange#of(LocalDate, LocalDate)}
     * Hint: The end date is exclusive in LocalDateRange
     */
    public FullMonth(LocalDate forDate, SortedSetMultimap<LocalDate, Meeting> calendarMeetings) {
        LocalDate start = null;
        LocalDate end = null;
        this.range = null;
        this.meetings = calendarMeetings.selectKeysValues(
                (date, meeting) ->
                        date.getMonth().equals(start.getMonth()) &&
                                date.getYear() == start.getYear());
    }

    @Override
    public String toString() {
        return "FullMonth(" +
                "start=" + this.getStart() +
                ", end=" + this.getEnd() +
                ", meetings=" + this.iterateMeetings() +
                ')';
    }
}
