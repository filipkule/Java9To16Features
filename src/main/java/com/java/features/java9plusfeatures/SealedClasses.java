package com.java.features.java9plusfeatures;

import java.util.Arrays;

public class SealedClasses {
    public static void main(String[] args) {
        int[] sides = {2, 3, 4, 5};
        Form rectangle = new Rectangle(sides);
        System.out.println(rectangle.calculatePerimeter());

        Form circle = new Circle(2.3f);
        System.out.println(circle.calculatePerimeter());

        Form triangle = new EquivalentTriangle("equivalent", 3);
        System.out.println(triangle.calculatePerimeter());
    }

    sealed static abstract class Form permits Rectangle, Circle, Triangle {
        String name;

        protected abstract double calculatePerimeter();
    }

    non-sealed static class Rectangle extends Form {
        int[] sides;

        public Rectangle(int[] sides) {
            this.sides = sides;
        }

        public int[] getSides() {
            return sides;
        }

        @Override
        protected double calculatePerimeter() {
            return Arrays.stream(getSides()).sum();
        }
    }

    static final class Circle extends Form {
        float r;

        public Circle(float r) {
            this.r = r;
        }

        @Override
        protected double calculatePerimeter() {
            return 2 * Math.PI * this.r;
        }
    }

    sealed static class Triangle extends Form {
        String type;

        @Override
        protected double calculatePerimeter() {
            return 0;
        }
    }

    static final class EquivalentTriangle extends Triangle {
        int side;

        public EquivalentTriangle(String type, int side) {
            this.type = type;
            this.side = side;
        }

        @Override
        protected double calculatePerimeter() {
            return 3 * side;
        }
    }

}
