package com.epam.task.multithreading.domain;

import com.epam.task.multithreading.util.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Uber {
    private static final Logger LOGGER = LogManager.getLogger();
    private final List<Taxi> taxis = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    private Uber() {
    }

    public void addTaxis(Taxi...taxis) {
        List<Taxi> newTaxis = Arrays.asList(taxis);
        this.taxis.addAll(newTaxis);
    }

    public void addTaxis(Collection<Taxi> taxis) {
        this.taxis.addAll(taxis);
    }

    public void addTaxis(Taxis taxis) {
        this.taxis.addAll(taxis.getTaxis());
    }

    public String callTaxi(Point clientLocation, Point destination) throws ModelException {
        if (taxis.size() == 0) {
            throw new ModelException("No taxis are available right now");
        }

        Taxi nearestTaxi;
        try {
           lock.lock();
            nearestTaxi = getNearestTaxi(clientLocation);
            while (nearestTaxi == null) {
                nearestTaxi = getNearestTaxi(clientLocation);
            }

            nearestTaxi.setRoute(clientLocation, destination);
        } finally {
            lock.unlock();
        }

        return nearestTaxi.getId();
    }

    public void freeTaxi(String id) {
        Optional<Taxi> taxiOptional = getTaxiById(id);
        if (taxiOptional.isPresent()) {
            Taxi taxi = taxiOptional.get();
            taxi.free();
        }
    }

    private Optional<Taxi> getTaxiById(String id) {
        int i = 0;
        Taxi taxi;
        String currentId;
        while (i < taxis.size()) {
            taxi = taxis.get(i);
            currentId = taxi.getId();
            if (currentId.equals(id)) {
                return Optional.of(taxis.get(i));
            }
            i++;
        }

        return Optional.empty();
    }

    private Taxi getNearestTaxi(Point location) {
        double leastDistance = Integer.MAX_VALUE;
        double distanceFromTaxi;
        Taxi leastDistanceTaxi = null;
        Point taxiLocation;
        Calculator calculator = new Calculator();

        for (Taxi taxi : taxis) {
            if (taxi.isReady()) {
                taxiLocation = taxi.getLocation();
                distanceFromTaxi = calculator.getsDistance(taxiLocation, location);
                if (leastDistance > distanceFromTaxi) {
                    leastDistance = distanceFromTaxi;
                    leastDistanceTaxi = taxi;
                }
            }
        }

        return leastDistanceTaxi;
    }

    public static Uber getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Uber INSTANCE = new Uber();
    }
}
