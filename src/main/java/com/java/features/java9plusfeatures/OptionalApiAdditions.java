package com.java.features.java9plusfeatures;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalApiAdditions {
    public static void main(String[] args) {
        ifPresentOrElse();
        or();
        stream();
    }

    private static void ifPresentOrElse() {
        System.out.println("ifPresentOrElse() example:");
        String user = "Jesus";
        Optional<String> optionalUser = Optional.of(user);
        Optional<String> optionalOfEmpty = Optional.empty();

        optionalUser.ifPresentOrElse(u -> System.out.println("Hello " + u),
                () -> System.out.println("Hello Stranger!"));
        optionalOfEmpty.ifPresentOrElse(u -> System.out.println("Hello " + u),
                () -> System.out.println("Hello Stranger!"));
        System.out.println("=============================================================");
    }

    private static void or() {
        System.out.println("or() example:");
        String user = "Jesus";
        Optional<String> optionalUser = Optional.of(user);
        Optional<String> optionalOfEmpty = Optional.empty();
        Optional<String> actualValue = optionalUser.or(() -> Optional.of("Stranger"));
        Optional<String> actualValueOfEmpty = optionalOfEmpty.or(() -> Optional.of("Stranger"));
        System.out.println("Hello " + actualValue.get());
        System.out.println("Hello " + actualValueOfEmpty.get());
        System.out.println("=============================================================");
    }

    private static void stream() {
        System.out.println("stream() example:");
        String user = "Jesus";
        Optional<String> optionalUser = Optional.of(user);
        Optional<String> optionalOfEmpty = Optional.empty();
        List<Optional<String>> optionalUsers = List.of(optionalUser, Optional.of("User"), Optional.of("Stranger"), optionalOfEmpty);
        List<String> users = optionalUsers.stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());
        users.forEach(u -> System.out.println("Hello " + u));
        System.out.println("=============================================================");
    }
}
