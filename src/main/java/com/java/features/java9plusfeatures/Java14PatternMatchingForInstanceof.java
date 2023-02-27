package com.java.features.java9plusfeatures;

public class Java14PatternMatchingForInstanceof {
    public static void main(String[] args) {
        System.out.println(calculatePerimeter(new EquivalentTriangle(2)));
        System.out.println(calculatePerimeter(new IsoscelesTriangle(2, 3)));
        System.out.println(calculatePerimeter(new ScalaneTriangle(2, 3, 2.5)));
    }

    public static double calculatePerimeter(Triangle triangle) {
        return switch (triangle) {
            case EquivalentTriangle et -> 3 * et.a();
            case IsoscelesTriangle it -> 2 * it.a() + it.b();
            case ScalaneTriangle st -> st.getA() + st.getB() + st.getC();
            default -> throw new IllegalStateException("Unexpected value: " + triangle);
        };
    }

    interface Triangle {
    }

    record EquivalentTriangle(double a) implements Triangle {}

    record IsoscelesTriangle(double a, double b) implements Triangle {}

    static class ScalaneTriangle implements Triangle {// this one is not refactored into a record for the sake of comparison
        double a;
        double b;
        double c;

        ScalaneTriangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }

        public double getC() {
            return c;
        }
    }
}
