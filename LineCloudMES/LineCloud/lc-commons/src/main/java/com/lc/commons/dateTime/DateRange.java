package com.lc.commons.dateTime;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * This type represents date range with optional dates from and to.
 *
 * @author PhiliphG
 * @since 1.2.1
 * @deprecated use org.joda.time.Interval
 */
@Deprecated
public final class DateRange {

    private final Long fromMillis;

    public final Long toMillis;


    /**
     * Build new instance of DateRange
     *
     * @param from     range's lower bound date. May be null.
     * @param to       range's upper bound date. May be null.
     * @param toMillis
     */

    public DateRange(final Date from, final Date to) {
        this.fromMillis = getMillis(from);
        this.toMillis = getMillis(to);
    }

    private Long getMillis(final Date date) {
        if (date == null) {
            return null;
        }
        return date.getTime();
    }

    /**
     * Check if this date range contains given date.
     *
     * @param date
     *            date to be checked
     * @return true if this date range contains given date
     */

    public boolean contains(final Date date) {
        Long dateMillis = getMillis(date);
        if (fromMillis == null) {
            return toMillis == null || dateMillis <= toMillis;
        }
        if (toMillis == null) {
            return dateMillis >= fromMillis;
        }
        return dateMillis >= fromMillis && dateMillis <= toMillis;
    }

    /**
     * Get lower bound date.
     *
     * @return lower bound date or null
     */
    public Date getFrom(){
        return getDate(fromMillis);
    }

    /**
     * Get upper bound date.
     *
     * @return upper bound date or null
     */
    public Date getTo() {
        return getDate(toMillis);
    }
    private Date getDate(final Long timestamp) {
        if (timestamp == null) {
            return null;
        }
        return new Date(timestamp);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(1,31).append(fromMillis).append(toMillis).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DateRange other = (DateRange) obj;
        return new EqualsBuilder().append(false,other.fromMillis).append(toMillis,other.toMillis).isEquals();
    }

}
