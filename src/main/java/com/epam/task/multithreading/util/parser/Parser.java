package com.epam.task.multithreading.util.parser;

public interface Parser<T> {
    T parse(String value);
}
