package solutions;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Issue15StreamInterface {
    public static void main(String[] args) {
        List<String> names = List.of("User", "Stranger", "", "User2", "", "User3");

        List<String> namesFilteredTakeWhile = names.stream()
                .takeWhile(name -> !name.isEmpty()).collect(Collectors.toList());
        //will return [User, Stranger], because the third value is empty string, the stream concludes with that
        System.out.println(namesFilteredTakeWhile);

        List<String> namesFilteredDropWhile = names.stream()
                .dropWhile(name -> !name.isEmpty()).collect(Collectors.toList());
        //all the values before the first empty string are dropped, the returned result is [, User2, , User3]
        System.out.println(namesFilteredDropWhile);

        List<Integer> intStreamIterate = IntStream.iterate(10, num -> num < 100, num -> num + 10)
                .boxed().collect(Collectors.toList());
        //this is one of the implementations of iterate, but it can be used on any variables type
        //[10, 20, 30, 40, 50, 60, 70, 80, 90] is the returned result. Note iterate can be used with any type of stream
        //not only IntStream
        System.out.println(intStreamIterate);

        List<List<String>> ofNullableList = Stream.ofNullable(names).collect(Collectors.toList());
        System.out.println(ofNullableList);
        //ofNullable helps us with streaming objects that might end up being empty or null
        List<Object> ofNullableNull = Stream.ofNullable(null).collect(Collectors.toList());
        System.out.println(ofNullableNull);
    }
}
