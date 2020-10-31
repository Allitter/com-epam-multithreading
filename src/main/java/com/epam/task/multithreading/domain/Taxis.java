package com.epam.task.multithreading.domain;

import java.util.ArrayList;
import java.util.List;

public class Taxis {
    private List<Taxi> taxis;

    public Taxis() {
    }

    public List<Taxi> getTaxis() {
        return new ArrayList<>(taxis);
    }

    @Override
    public String toString() {
        return "Taxis{" +
                "taxis=" + taxis +
                '}';
    }
}
