package com.epam.task.multithreading.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class TaxiClient implements Runnable {
    private static final Logger LOGGER = LogManager.getLogger();
    private final Point location;
    private Point destination;
    private String taxiId;
    private String name;
    private Uber uber;

    public TaxiClient() {
        location = new Point();
    }

    public void setUber(Uber uber) {
        this.uber = uber;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void run() {
        try {
            uber = Uber.getInstance();
            callTaxi();
            LOGGER.info(String.format("%s freed the taxi%s%n", name, taxiId));
            uber.freeTaxi(taxiId);
        } catch (InterruptedException | ModelException e) {
            LOGGER.error(e);
        }
    }

    private void callTaxi() throws InterruptedException, ModelException {
        taxiId = uber.callTaxi(location, destination);
        LOGGER.info(String.format("%s got the uber %s%n", name, taxiId));
        TimeUnit.SECONDS.sleep(1);

    }
}
