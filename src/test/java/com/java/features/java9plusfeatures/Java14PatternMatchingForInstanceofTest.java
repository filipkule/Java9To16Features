package com.java.features.java9plusfeatures;

import org.junit.jupiter.api.Test;

import static com.java.features.java9plusfeatures.Java14PatternMatchingForInstanceof.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java14PatternMatchingForInstanceofTest {

    @Test
    public void calculatePerimeterTest() {
        Triangle equivalentTriangle = new EquivalentTriangle(2);
        Triangle isoscelesTriangle = new IsoscelesTriangle(2, 3);
        Triangle scalaneTriangle = new ScalaneTriangle(2, 3, 2.5);

        double equivalentTrianglePerimeter = calculatePerimeter(equivalentTriangle);
        double isoscelesTrianglePerimeter = calculatePerimeter(isoscelesTriangle);
        double scalaneTrianglePerimeter = calculatePerimeter(scalaneTriangle);

        assertEquals(6.0, equivalentTrianglePerimeter);
        assertEquals(7.0, isoscelesTrianglePerimeter);
        assertEquals(7.0, scalaneTrianglePerimeter);
    }
}
