package com.epam.task.multithreading.util.parser;

import com.epam.task.multithreading.domain.TaxiClient;
import com.epam.task.multithreading.domain.TaxiClients;
import org.junit.Assert;
import org.junit.Test;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TaxiClientParserTest {
    private static final String CORRECT_INPUT = "{\"clients\":[{\"name\":\"Peck\",\"location\":{\"x\": -895,\"y\": -40}," +
            "\"destination\":{\"x\":-169,\"y\":-760}},{\"name\":\"Jeannie\",\"location\":{\"x\":-139,\"y\":319}," +
            "\"destination\":{\"x\":-926,\"y\": -87}}]}";

    @Test
    public void testParseShouldParseWhenInputIsCorrect() {
        TaxiClientParser parser = new TaxiClientParser();

        TaxiClients actual = parser.parse(CORRECT_INPUT);

        List<TaxiClient> clients = Arrays.asList(
                new TaxiClient(new Point(-895, -40), new Point(-169, -760), "Peck"),
                new TaxiClient(new Point(-139, 319), new Point(-926, -87), "Jeannie"));
        TaxiClients expected = new TaxiClients(clients);
        Assert.assertEquals(expected, actual);
    }
}