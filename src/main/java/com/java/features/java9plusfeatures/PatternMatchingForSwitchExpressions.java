package com.java.features.java9plusfeatures;

public class PatternMatchingForSwitchExpressions {
    public static void main(String[] args) {
        EquivalentTriangle et = new EquivalentTriangle(2);
        System.out.println(validateObject(et));

        Person p = new Person("Stranger", "Town");
        System.out.println(validateObject(p));

        System.out.println(validateObject("Invalid input"));
    }

    public static String validateObject(Object o) {
        return switch (o) {
            case EquivalentTriangle et -> "The object is a valid triangle, with side: " + et.a();// case EquivalentTriangle et && et.a() > 0 -> "The object is a valid triangle";
            case Person p -> "The object is a valid person, with name: " + p.name();             // The above is also allowed in Java 17
            default -> "Invalid object";
        };
    }

    record EquivalentTriangle(double a){}
    record Person(String name, String city){}

}
