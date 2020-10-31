package com.epam.task.multithreading;

import com.epam.task.multithreading.data.Reader;
import com.epam.task.multithreading.data.exception.DataException;
import com.epam.task.multithreading.data.impl.FileReader;
import com.epam.task.multithreading.domain.TaxiClients;
import com.epam.task.multithreading.domain.Taxis;
import com.epam.task.multithreading.domain.Uber;
import com.epam.task.multithreading.util.parser.TaxiClientParser;
import com.epam.task.multithreading.util.parser.TaxisParser;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws DataException {
        Reader reader = new FileReader();
        String taxisJson = reader.read("taxis.json");
        Taxis taxis = new TaxisParser().parse(taxisJson);
        Uber uber = Uber.getInstance();
        uber.addTaxis(taxis);
        String taxiClientJson = reader.read("clients.json");
        TaxiClients taxiClients = new TaxiClientParser().parse(taxiClientJson);

        ExecutorService executorService = Executors.newCachedThreadPool();
        taxiClients.getClients().forEach(executorService::submit);

        executorService.shutdown();
    }
}
