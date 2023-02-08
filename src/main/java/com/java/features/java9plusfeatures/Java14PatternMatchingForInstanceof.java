package com.java.features.java9plusfeatures;

public class Java14PatternMatchingForInstanceof {
    public static void main(String[] args) {
        System.out.println(calculatePerimeter(new EquivalentTriangle(2)));
        System.out.println(calculatePerimeter(new IsoscelesTriangle(2, 3)));
        System.out.println(calculatePerimeter(new ScalaneTriangle(2, 3, 2.5)));
    }

    public static double calculatePerimeter(Triangle triangle) {
        return switch (triangle) {
            case EquivalentTriangle et -> 3 * et.getA();
            case IsoscelesTriangle it -> 2 * it.getA() + it.getB();
            case ScalaneTriangle st -> st.getA() + st.getB() + st.getC();
            default -> throw new IllegalStateException("Unexpected value: " + triangle);
        };
    }

    interface Triangle {
    }

    static class EquivalentTriangle implements Triangle {
        double a;
        EquivalentTriangle (double a) {
            this.a = a;
        }

        public double getA() {
            return a;
        }
    }

    static class IsoscelesTriangle implements Triangle {
        double a;
        double b;

        IsoscelesTriangle(double a, double b) {
            this.a = a;
            this.b = b;
        }

        public double getA() {
            return a;
        }

        public double getB() {
            return b;
        }
    }

    static class ScalaneTriangle implements Triangle {
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
