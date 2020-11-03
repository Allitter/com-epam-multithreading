package com.epam.task.multithreading.domain;

import java.util.List;
import java.util.Objects;

public class TaxiClients {
    private List<TaxiClient> clients;

    public TaxiClients() {
    }

    public TaxiClients(List<TaxiClient> clients) {
        this.clients = clients;
    }

    public List<TaxiClient> getClients() {
        return clients;
    }

    public int getCount() {
        return clients.size();
    }

    @Override
    public String toString() {
        return "TaxiClients{" +
                "clients=" + clients +
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
        TaxiClients clients1 = (TaxiClients) o;
        return Objects.equals(getClients(), clients1.getClients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClients());
    }
}
