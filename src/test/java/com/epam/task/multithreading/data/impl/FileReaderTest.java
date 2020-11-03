package com.epam.task.multithreading.data.impl;

import com.epam.task.multithreading.data.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

public class FileReaderTest {
    private static final String TEST_FILE_PATH = "src/test/resources/file_to_test_reader";
    private static final String NOT_EXISTING_FILE = "not existing file";
    private static final String TEST_FILE_TEXT = "text\ntext\ntext";

    @Test
    public void testReadShouldReadAllTextIfFileExists() throws DataException {
        FileReader fileReader = new FileReader();

        String actual = fileReader.read(TEST_FILE_PATH);

        Assert.assertEquals(TEST_FILE_TEXT, actual);
    }

    @Test(expected = DataException.class)
    public void testReadShouldThrowExceptionIfFileNOtExists() throws DataException {
        FileReader fileReader = new FileReader();

        fileReader.read(NOT_EXISTING_FILE);
    }
}