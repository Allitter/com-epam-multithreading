package com.epam.task.multithreading.domain;

import java.awt.*;
import java.util.Objects;

public class Taxi {
    private final String id;
    private Point location;
    private Point clientLocation;
    private Point destination;
    private boolean isReady;

    public Taxi(String id, Point location) {
        this.id = id;
        this.location = location;
        this.isReady = true;
    }

    public void setRoute(Point clientLocation, Point destination) {
        this.clientLocation = clientLocation;
        this.destination = destination;
        isReady = false;
    }

    public void free() {
        location = destination;
        isReady = true;
    }

    public boolean isReady() {
        return isReady;
    }

    public String getId() {
        return id;
    }

    public Point getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id='" + id + '\'' +
                ", location=" + location +
                ", isReady=" + isReady +
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
        Taxi taxi = (Taxi) o;
        return isReady() == taxi.isReady() &&
                Objects.equals(getId(), taxi.getId()) &&
                Objects.equals(getLocation(), taxi.getLocation()) &&
                Objects.equals(clientLocation, taxi.clientLocation) &&
                Objects.equals(destination, taxi.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLocation(), clientLocation, destination, isReady());
    }
}
