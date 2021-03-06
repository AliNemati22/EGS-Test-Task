package com.nemati.utils.jpa;

import java.util.Objects;

public class StringFilter extends Filter<String> {
    private static final long serialVersionUID = 1L;
    private String contains;

    public StringFilter() {
    }

    public StringFilter(StringFilter filter) {
        super(filter);
        this.contains = filter.contains;
    }

    public StringFilter copy() {
        return new StringFilter(this);
    }

    public String getContains() {
        return this.contains;
    }

    public StringFilter setContains(String contains) {
        this.contains = contains;
        return this;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            if (!super.equals(o)) {
                return false;
            } else {
                StringFilter that = (StringFilter)o;
                return Objects.equals(this.contains, that.contains);
            }
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{super.hashCode(), this.contains});
    }

    public String toString() {
        return this.getFilterName() + " [" + (this.getEquals() != null ? "equals=" + (String)this.getEquals() + ", " : "") +  (this.getContains() != null ? "contains=" + this.getContains() + ", " : "")  + "]";
    }
}
