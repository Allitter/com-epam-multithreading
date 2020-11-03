package com.epam.task.multithreading.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.*;
import java.util.Objects;

public class TaxiClient implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Point location;
    private final Point destination;
    private final String name;
    private String taxiId;
    private Uber uber;

    public TaxiClient(Point location, Point destination, String name) {
        this.location = location;
        this.destination = destination;
        this.name = name;
    }

    public void run() {
        try {
            uber = Uber.getInstance();
            callTaxi();
            LOGGER.info(String.format("%s freed the taxi%s%n", name, taxiId));
            uber.freeTaxi(taxiId);
        } catch (DomainException e) {
            LOGGER.error(e);
        }
    }

    private void callTaxi() throws DomainException {
        taxiId = uber.callTaxi(location, destination);
        LOGGER.info(String.format("%s got the uber %s%n", name, taxiId));
    }

    public Point getLocation() {
        return location;
    }

    public Point getDestination() {
        return destination;
    }

    public String getName() {
        return name;
    }

    public String getTaxiId() {
        return taxiId;
    }

    @Override
    public String toString() {
        return "TaxiClient{" +
                "location=" + location +
                ", destination=" + destination +
                ", taxiId='" + taxiId + '\'' +
                ", name='" + name + '\'' +
                ", uber=" + uber +
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
        TaxiClient that = (TaxiClient) o;
        return Objects.equals(location, that.location) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(name, that.name) &&
                Objects.equals(taxiId, that.taxiId) &&
                Objects.equals(uber, that.uber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, destination, name, taxiId, uber);
    }
}
