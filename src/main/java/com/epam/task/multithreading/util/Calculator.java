package com.epam.task.multithreading.util;

import java.awt.*;

public class Calculator {
    public double getsDistance(Point firstPoint, Point secondPoint) {
        double x1 = firstPoint.getX();
        double x2 = secondPoint.getX();
        double y1 = firstPoint.getY();
        double y2 = secondPoint.getY();

        return Math.sqrt((x1 - x2) * (x1 - x2)  + (y1 - y2) * (y1 - y2));
    }
}
