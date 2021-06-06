package solutions;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Issue9ImmutableCollections {
    public static void main(String[] args) {
        immutableList();
        immutableSet();
        immutableMap();
    }

    private static void immutableList(){
        System.out.println("Immutable List example");
        List<String> names = List.of("User", "Stranger");
//        names.add("User2"); Not possible
        names.forEach(name -> System.out.println("Hello " + name));
        System.out.println("=============================================================");
    }

    private static void immutableSet(){
        System.out.println("Immutable Set example");
        Set<String> names = Set.of("User", "Stranger");
//        names.add("User2"); //Not possible
        names.forEach(name -> System.out.println("Hello " + name));
        System.out.println("=============================================================");
    }

    private static void immutableMap(){
        System.out.println("Immutable Map example");
        Map<String, Integer> people = Map.of("User", 21, "Stranger", 26);
//        people.put("User2", 20); //Not possible
        people.keySet().forEach(person -> System.out.println("Name: " + person + " Age: " + people.get(person)));
    }
}
