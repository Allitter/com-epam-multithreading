package com.epam.task.multithreading.util.parser;

import com.epam.task.multithreading.domain.Taxi;
import com.epam.task.multithreading.domain.Taxis;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class TaxisParserTest {
    private static final String CORRECT_INPUT = "{\"taxis\":[{\"id\":\"ID1\",\"location\":" +
            "{\"x\":10,\"y\":15},\"isReady\":\"true\"},{\"id\":\"ID2\",\"location\":" +
            "{\"x\":-10,\"y\":-5},\"isReady\":\"true\"}]}";


    @Test
    public void testParseShouldReturnTaxisWhenInputIsCorrect() {
        TaxisParser parser = new TaxisParser();

        Taxis actual = parser.parse(CORRECT_INPUT);

        List<Taxi> taxis = Arrays.asList(
                new Taxi("ID1", new Point(10, 15)),
                new Taxi("ID2", new Point(-10, -5)));
        Taxis expected = new Taxis(taxis);
        Assert.assertEquals(expected, actual);
    }
}