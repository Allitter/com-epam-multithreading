package com.epam.task.multithreading.util.parser;

import com.epam.task.multithreading.domain.TaxiClients;
import com.google.gson.Gson;

public class TaxiClientParser implements Parser<TaxiClients> {
    @Override
    public TaxiClients parse(String value) {
        Gson gson = new Gson();
        return gson.fromJson(value, TaxiClients.class);
    }
}
