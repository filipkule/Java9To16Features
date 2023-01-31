import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateNotMethod {
    public static void main(String[] args) {
        Predicate isStringPredicate = (o) -> o instanceof String;
        Predicate notStringPredicate = Predicate.not(isStringPredicate);

        boolean isString = isStringPredicate.test(12);
        boolean notString = notStringPredicate.test(12);

        System.out.println("Is String:" + isString);
        System.out.println("Not String:" + notString);

        List<String> stringList = List.of("String", "", "String1", "String2");
        List<String> filterWithNotPredicate = stringList.stream().filter(Predicate.not(String::isBlank)).collect(Collectors.toList());
        filterWithNotPredicate.stream().forEach(System.out::println);
    }
}
