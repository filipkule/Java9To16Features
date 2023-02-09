package com.java.features.java9plusfeatures;

import java.util.List;

public class Java14Record {
    public static void main(String[] args) {
        Person person = new Person("Stranger", 30, List.of("Friend"));
        System.out.println("Hello " + person.name());// Generated getters
        System.out.println("Age: " + person.age());
        System.out.println("Number of Friends: " + person.friends().size());
        person.friends.add("SecondFriend");
        System.out.println("Number of Friends: " + person.friends().size());
        // To get a better understanding go to Java14RecordTest.java
        // Where we go deeper into how to keep record immutable if needed
    }
    public record Person(String name, int age, List<String> friends){}

    public record PersonImmutable(String name, int age, List<String> friends) {
        public PersonImmutable(String name, int age, List<String> friends) {
            this.name = name;
            this.age = age;
            this.friends = List.copyOf(friends);
        }
    }
}
