package com.java.features.java9plusfeatures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnmodifiableImmutableCollections {
    public static void main(String[] args) {
        List<Integer> intList  = new ArrayList<>();
        intList.add(5);
        intList.add(4);
        intList.add(3);
        intList.add(2);
        intList.add(1);
        List<Integer> unmodifiableList = List.copyOf(intList);
//        addToUnmodifiableList(6, unmodifiableList);// This will throw UnsupportedOperationException
        List<Integer> unmodifiableList2 = intList.stream().collect(Collectors.toUnmodifiableList());
//        addToUnmodifiableList(6, unmodifiableList2);// This will throw UnsupportedOperationException
    }

    public static void addToUnmodifiableList(Integer itemToAdd, List<Integer> unmodifiableList) {
        unmodifiableList.add(itemToAdd);
    }
}
