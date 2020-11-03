package com.epam.task.multithreading.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Taxis {
    private List<Taxi> taxis;

    public Taxis() {
    }

    public Taxis(List<Taxi> taxis) {
        this.taxis = taxis;
    }

    public List<Taxi> getTaxis() {
        return new ArrayList<>(taxis);
    }

    public int getCount() {
        return taxis.size();
    }

    @Override
    public String toString() {
        return "Taxis{" +
                "taxis=" + taxis +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Taxis taxis1 = (Taxis) o;
        return Objects.equals(getTaxis(), taxis1.getTaxis());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaxis());
    }
}
