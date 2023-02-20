package com.java.features.java9plusfeatures;

import java.util.List;
import java.util.stream.Collectors;

public class Java16StreamToListMethod {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);

        List<String> stringsBeforeJava16 = numbers.stream().map(n -> "Number " + n).collect(Collectors.toList());
        List<String> strings = numbers.stream().map(n -> "Number " + n).toList();// instead of using collect(Collectors.toList()) we can use toList()

        strings.forEach(System.out::println);
    }
}
