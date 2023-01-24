import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnmodifiableImmutableCollectionsTest {

    @Test
    public void addToUnmodifiableListTest() {
        List<Integer> intList  = new ArrayList<>();
        intList.add(5);
        intList.add(4);
        intList.add(3);
        intList.add(2);
        intList.add(1);
        List<Integer> unmodifiableList1 = List.copyOf(intList);
        List<Integer> unmodifiableList2 = intList.stream().collect(Collectors.toUnmodifiableList());


        Assertions.assertThrows(UnsupportedOperationException.class, () ->
                UnmodifiableImmutableCollections.addToUnmodifiableList(1, List.of(2,3,4)));
        Assertions.assertThrows(UnsupportedOperationException.class, () ->
                UnmodifiableImmutableCollections.addToUnmodifiableList(6, unmodifiableList1));
        Assertions.assertThrows(UnsupportedOperationException.class, () ->
                UnmodifiableImmutableCollections.addToUnmodifiableList(6, unmodifiableList2));
    }
}
