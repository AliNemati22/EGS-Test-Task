package com.nemati.utils.jpa;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.time.LocalDate;

public class LocalDateFilter extends RangeFilter<LocalDate> {
    private static final long serialVersionUID = 1L;

    public LocalDateFilter() {
    }

    public LocalDateFilter(LocalDateFilter filter) {
        super(filter);
    }

    public LocalDateFilter copy() {
        return new LocalDateFilter(this);
    }

    @DateTimeFormat(
        iso = ISO.DATE
    )
    public LocalDateFilter setEquals(LocalDate equals) {
        super.setEquals(equals);
        return this;
    }

    @DateTimeFormat(
        iso = ISO.DATE
    )
    public LocalDateFilter setGreaterThanOrEqual(LocalDate equals) {
        super.setGreaterThanOrEqual(equals);
        return this;
    }

    /** @deprecated */
    @DateTimeFormat(
        iso = ISO.DATE
    )
    @Deprecated
    public LocalDateFilter setGreaterOrEqualThan(LocalDate equals) {
        super.setGreaterOrEqualThan(equals);
        return this;
    }

    @DateTimeFormat(
        iso = ISO.DATE
    )
    public LocalDateFilter setLessThanOrEqual(LocalDate equals) {
        super.setLessThanOrEqual(equals);
        return this;
    }

    /** @deprecated */
    @DateTimeFormat(
        iso = ISO.DATE_TIME
    )
    @Deprecated
    public LocalDateFilter setLessOrEqualThan(LocalDate equals) {
        super.setLessOrEqualThan(equals);
        return this;
    }
}
