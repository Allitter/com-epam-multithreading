package com.epam.task.multithreading.data;

import com.epam.task.multithreading.data.exception.DataException;

public interface Reader {

     String read(String path) throws DataException;

}
