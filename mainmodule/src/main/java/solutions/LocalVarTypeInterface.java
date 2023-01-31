import java.util.List;
import java.util.function.BiFunction;

public class LocalVarTypeInterface {
    public static void main(String[] args) {
        String name = "Stranger";
        var nameVar = "Stranger";
        System.out.println("Hello " + name);
        System.out.println("Hello " + nameVar);

        List<String> names = List.of("name1", "Stranger");
        var namesVar = List.of("name1", "Stranger");
        System.out.println(names);
        System.out.println(namesVar);

        BiFunction<Integer, Integer, Integer> func = (a, b) -> a + b;
        BiFunction<Integer, Integer, Integer> funcVar = (var a, var b) -> a + b;//var can be used in lambda expressions
        var resultFunc = func.apply(10, 15);
        var resultFuncVar = funcVar.apply(10, 15);
        System.out.println(resultFunc);
        System.out.println(resultFuncVar);

    }
}
