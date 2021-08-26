package com.nemati.utils.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

public class Filter<FIELD_TYPE> implements Serializable {
    private static final long serialVersionUID = 1L;
    private FIELD_TYPE equals;
    @JsonIgnore
    private Boolean specified;

    public Filter() {
    }

    public Filter(Filter<FIELD_TYPE> filter) {
        this.equals = filter.equals;
    }

    public Filter<FIELD_TYPE> copy() {
        return new Filter(this);
    }

    public FIELD_TYPE getEquals() {
        return this.equals;
    }

    public Filter<FIELD_TYPE> setEquals(FIELD_TYPE equals) {
        this.equals = equals;
        return this;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Filter<?> filter = (Filter) o;
            return Objects.equals(this.equals, filter.equals);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.equals});
    }

    public String toString() {
        return this.getFilterName() + " [" + (this.getEquals() != null ? "equals=" + this.getEquals() + ", " : "") + "]";
    }

    protected String getFilterName() {
        return this.getClass().getSimpleName();
    }


    public Boolean getSpecified() {
        return this.specified;
    }


    public Filter<FIELD_TYPE> setSpecified(Boolean specified) {
        this.specified = specified;
        return this;
    }
}
