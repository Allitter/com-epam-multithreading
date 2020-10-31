package com.epam.task.multithreading.domain;

import java.awt.*;

public class Taxi {
    private final String id;
    private Point location;
    private Point clientLocation;
    private Point destination;
    private boolean isReady = true;

    public Taxi(String id) {
        this.id = id;
        location = new Point();
    }

    public Taxi(String id, Point location) {
        this.id = id;
        this.location = location;
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

    public void setLocation(Point location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id='" + id + '\'' +
                ", location=" + location +
                ", isReady=" + isReady +
                '}';
    }
}
