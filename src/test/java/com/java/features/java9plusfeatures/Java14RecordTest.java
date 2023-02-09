package com.java.features.java9plusfeatures;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.java.features.java9plusfeatures.Java14Record.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
