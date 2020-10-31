package com.epam.task.multithreading.data.impl;

import com.epam.task.multithreading.data.Reader;
import com.epam.task.multithreading.data.exception.DataException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReader implements Reader {
    @Override
    public String read(String path) throws DataException {
        try {
            List<String> strings = Files.readAllLines(Paths.get(path));
            return String.join(" ", strings);
        } catch (IOException e) {
            throw new DataException(e);
        }
    }
}
