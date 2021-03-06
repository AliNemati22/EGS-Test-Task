package com.nemati.utils.jpa;

public class DoubleFilter extends RangeFilter<Double> {
    private static final long serialVersionUID = 1L;

    public DoubleFilter() {
    }

    public DoubleFilter(DoubleFilter filter) {
        super(filter);
    }

    public DoubleFilter copy() {
        return new DoubleFilter(this);
    }
}
