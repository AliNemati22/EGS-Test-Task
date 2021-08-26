package com.nemati.utils.jpa;

import java.util.Objects;

public class RangeFilter<FIELD_TYPE extends Comparable<? super FIELD_TYPE>> extends Filter<FIELD_TYPE> {
    private static final long serialVersionUID = 1L;
    private FIELD_TYPE greaterThanOrEqual;
    private FIELD_TYPE lessThanOrEqual;


    public RangeFilter() {
    }

    public RangeFilter(RangeFilter<FIELD_TYPE> filter) {
        super(filter);
        this.greaterThanOrEqual = filter.greaterThanOrEqual;
        this.lessThanOrEqual = filter.lessThanOrEqual;
    }

    public RangeFilter<FIELD_TYPE> copy() {
        return new RangeFilter(this);
    }


    public FIELD_TYPE getGreaterThanOrEqual() {
        return this.greaterThanOrEqual;
    }

    public RangeFilter<FIELD_TYPE> setGreaterThanOrEqual(FIELD_TYPE greaterThanOrEqual) {
        this.greaterThanOrEqual = greaterThanOrEqual;
        return this;
    }

    /** @deprecated */
    @Deprecated
    public RangeFilter<FIELD_TYPE> setGreaterOrEqualThan(FIELD_TYPE greaterThanOrEqual) {
        this.setGreaterThanOrEqual(greaterThanOrEqual);
        return this;
    }

    public FIELD_TYPE getLessThanOrEqual() {
        return this.lessThanOrEqual;
    }

    public RangeFilter<FIELD_TYPE> setLessThanOrEqual(FIELD_TYPE lessThanOrEqual) {
        this.lessThanOrEqual = lessThanOrEqual;
        return this;
    }

    /** @deprecated */
    @Deprecated
    public RangeFilter<FIELD_TYPE> setLessOrEqualThan(FIELD_TYPE lessThanOrEqual) {
        this.setLessThanOrEqual(lessThanOrEqual);
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            if (!super.equals(o)) {
                return false;
            } else {
                RangeFilter<?> that = (RangeFilter)o;
                return Objects.equals(this.greaterThanOrEqual, that.greaterThanOrEqual) && Objects.equals(this.lessThanOrEqual, that.lessThanOrEqual);
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{super.hashCode(), this.greaterThanOrEqual, this.lessThanOrEqual});
    }

    public String toString() {
        return this.getFilterName() + " [" + (this.getEquals() != null ? "equals=" + this.getEquals() + ", " : "") + (this.getGreaterThanOrEqual() != null ? "greaterThanOrEqual=" + this.getGreaterThanOrEqual() + ", " : "") + (this.getLessThanOrEqual() != null ? "lessThanOrEqual=" + this.getLessThanOrEqual() : "") + "]";
    }
}
