package com.java.features.java9plusfeatures;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingCollector {
    public static void main(String[] args) {
        Double letterAvg = Stream.of("One", "Two", "Three").collect(Collectors.teeing(
                Collectors.summingDouble(w -> w.length()), Collectors.counting(),
                (w, n) -> w / n));
        System.out.println(letterAvg);
    }
}
