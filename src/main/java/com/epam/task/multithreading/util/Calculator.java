package com.epam.task.multithreading.util;

import java.awt.*;

public class Calculator {
    public double getsDistance(Point firstPoint, Point secondPoint) {
        double x1 = firstPoint.getX();
        double x2 = secondPoint.getX();
        double y1 = firstPoint.getY();
        double y2 = secondPoint.getY();

        double firstDistance = Math.hypot(x1, y1);
        double secondDistance = Math.hypot(x2, y2);

        return Math.abs(firstDistance - secondDistance);
    }
}
