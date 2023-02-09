package com.java.features.java9plusfeatures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.java.features.java9plusfeatures.Java14Record.Person;
import static com.java.features.java9plusfeatures.Java14Record.PersonImmutable;
import static org.junit.jupiter.api.Assertions.*;

public class Java14RecordTest {

    @Test
    public void recordTest() {
        List<String> friends = new ArrayList<>();
        friends.add("Frined1");
        friends.add("Frined2");
        Person person = new Person("Stranger", 30, friends);

        assertEquals("Stranger", person.name());
        assertEquals(30, person.age());

        // Record object are unmodifiable, but they are not immutable
        // If the object is mutable then you can modify it in a couple of ways
        // Bellow you can see
        assertEquals(2, person.friends().size());
        friends.add("Friend3");
        assertEquals(3, person.friends().size());
        List<String> friendsToAdd = person.friends();
        friendsToAdd.add("Friend4");
        assertEquals(4, person.friends().size());
        person.friends().add("Friend5");
        assertEquals(5, person.friends().size());
    }

    @Test
    public void actualImmutableRecord() {

        Person person = new Person("Stranger", 30, List.of("Friend"));
        // One way to make records immutable is to use immutable object
        // for instance List.of() returns Immutable collection
        assertThrows(UnsupportedOperationException.class, () -> person.friends().add("NewFriend"));

        // Another way to make Records immutable is by creating a custom constructor implementation
        // you can check the implementation for our case by looking at the PersonImmutable record.
        // Where we convert the mutable list into immutable by using the List.copyOf() method
        List<String> friends = new ArrayList<>();
        friends.add("Frined1");
        friends.add("Frined2");
        PersonImmutable personImmutable = new PersonImmutable("Stranger", 30, friends);
        assertEquals("Stranger", personImmutable.name());
        assertEquals(30, personImmutable.age());
        assertEquals(2, personImmutable.friends().size());

        assertThrows(UnsupportedOperationException.class, () -> personImmutable.friends().add("NewFriend"));
    }
}
