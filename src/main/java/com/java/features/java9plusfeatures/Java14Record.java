package com.java.features.java9plusfeatures;

import java.util.List;

public class Java14Record {
    public static void main(String[] args) {
        Person person = new Person("Stranger", 30, List.of("Friend"));
        System.out.println("Hello " + person.name());// Generated getters
        System.out.println("Age: " + person.age());
        System.out.println("Number of Friends: " + person.friends().size());
        // To get a better understanding go to Java14RecordTest.java
    }
    public record Person(String name, int age, List<String> friends){}

}
