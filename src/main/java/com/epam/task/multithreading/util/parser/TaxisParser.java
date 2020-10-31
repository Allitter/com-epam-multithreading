package com.epam.task.multithreading.util.parser;

import com.epam.task.multithreading.domain.Taxis;
import com.google.gson.Gson;

public class TaxisParser implements Parser<Taxis> {
    @Override
    public Taxis parse(String value) {
        Gson gson = new Gson();
        return gson.fromJson(value, Taxis.class);
    }
}
