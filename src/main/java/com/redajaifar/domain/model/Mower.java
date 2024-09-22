package com.redajaifar.domain.model;

import java.util.AbstractMap;
import java.util.Objects;

public class Mower {

    private AbstractMap.SimpleEntry<Integer, Integer> position;
    private Orientation orientation;

    public Mower(AbstractMap.SimpleEntry position, Orientation orientation) {
        this.position = position;
        this.orientation = orientation;

    }

    public AbstractMap.SimpleEntry<Integer, Integer> getPosition() {
        return position;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mower mower = (Mower) o;
        return position.equals(mower.position) && orientation == mower.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, orientation);
    }
}
