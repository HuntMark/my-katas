package my.rinat.kata.datetime.calendarkata;

import java.time.LocalDate;

import org.eclipse.collections.api.multimap.Multimap;
import org.threeten.extra.LocalDateRange;

public class CalendarWindow {
    LocalDateRange range;
    Multimap<LocalDate, Meeting> meetings;

    public LocalDate getStart() {
        return this.range.getStart();
    }

    public LocalDate getEnd() {
        return this.range.getEnd().minusDays(1);
    }

    public int getNumberOfMeetings() {
        return this.meetings.size();
    }

    protected String iterateMeetings() {
        StringBuilder builder = new StringBuilder();
        this.range.stream().forEach(date -> {
            builder.append("Date=" + date);
            builder.append(" {Meetings= ");
            builder.append(this.meetings.get(date));
            builder.append("} ");
        });
        return builder.toString();
    }
}
