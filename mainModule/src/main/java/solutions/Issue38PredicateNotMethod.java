import java.util.function.Predicate;

public class Issue38PredicateNotMethod {
    public static void main(String[] args) {
        Predicate isStringPredicate = (o) -> o instanceof String;
        Predicate notStringPredicate = Predicate.not(isStringPredicate);

        boolean isString = isStringPredicate.test(12);
        boolean notString = notStringPredicate.test(12);

        System.out.println("Is String:" + isString);
        System.out.println("Not String:" + notString);

    }
}
