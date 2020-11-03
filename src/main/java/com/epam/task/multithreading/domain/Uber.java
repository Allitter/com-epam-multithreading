package com.epam.task.multithreading.domain;

import com.epam.task.multithreading.util.Calculator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Uber {
    private final List<Taxi> taxis = new ArrayList<>();
    private final Lock lock = new ReentrantLock();

    private Uber() {
    }

    public void addTaxis(Collection<Taxi> taxis) {
        this.taxis.addAll(taxis);
    }

    public void addTaxis(Taxis taxis) {
        this.taxis.addAll(taxis.getTaxis());
    }

    public String callTaxi(Point clientLocation, Point destination) throws DomainException {
        if (taxis.size() == 0) {
            throw new DomainException("No taxis are available right now");
        }

        Taxi nearestTaxi;
        try {
           lock.lock();
           do {
               nearestTaxi = getNearestTaxi(clientLocation);
           } while (nearestTaxi == null);

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
        double leastDistance = Double.MAX_VALUE;
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
