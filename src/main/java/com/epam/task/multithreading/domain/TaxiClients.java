package com.epam.task.multithreading.domain;

import java.util.List;

public class TaxiClients {
    private List<TaxiClient> clients;

    public List<TaxiClient> getClients() {
        return clients;
    }

    @Override
    public String toString() {
        return "TaxiClients{" +
                "clients=" + clients +
                '}';
    }
}
