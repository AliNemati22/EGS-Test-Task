package com.nemati.utils.jpa;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.ZonedDateTime;

public class ZonedDateTimeFilter extends RangeFilter<ZonedDateTime> {
    private static final long serialVersionUID = 1L;

    public ZonedDateTimeFilter() {
    }

    public ZonedDateTimeFilter(ZonedDateTimeFilter filter) {
        super(filter);
    }

    public ZonedDateTimeFilter copy() {
        return new ZonedDateTimeFilter(this);
    }

    @DateTimeFormat(
    )
    public ZonedDateTimeFilter setEquals(ZonedDateTime equals) {
        super.setEquals(equals);
        return this;
    }

    @DateTimeFormat(
        iso = ISO.DATE_TIME
    )
    public ZonedDateTimeFilter setGreaterThanOrEqual(ZonedDateTime equals) {
        super.setGreaterThanOrEqual(equals);
        return this;
    }

    /** @deprecated */
    @DateTimeFormat(
        iso = ISO.DATE_TIME
    )
    @Deprecated
    public ZonedDateTimeFilter setGreaterOrEqualThan(ZonedDateTime equals) {
        super.setGreaterOrEqualThan(equals);
        return this;
    }

    @DateTimeFormat(
        iso = ISO.DATE_TIME
    )
    public ZonedDateTimeFilter setLessThanOrEqual(ZonedDateTime equals) {
        super.setLessThanOrEqual(equals);
        return this;
    }

    /** @deprecated */
    @DateTimeFormat(
        iso = ISO.DATE_TIME
    )
    @Deprecated
    public ZonedDateTimeFilter setLessOrEqualThan(ZonedDateTime equals) {
        super.setLessOrEqualThan(equals);
        return this;
    }
}
