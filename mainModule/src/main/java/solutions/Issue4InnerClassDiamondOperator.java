package solutions;

public class Issue4InnerClassDiamondOperator {
    public static void main(String[] args) {
        AbstractAddition<Integer> additionIntegers = new AbstractAddition<Integer>() {
            @Override
            Integer add(Integer firstArgument, Integer secondArgument) {
                result = firstArgument + secondArgument;
                return result;
            }
        };

        AbstractAddition<String> additionString = new AbstractAddition<>() {
            @Override
            String add(String firstArgument, String secondArgument) {
                result = firstArgument + secondArgument;
                return result;
            }
        };

        System.out.println(additionIntegers.add(1, 2));
        System.out.println(additionString.add("Hello ", "Stranger!"));
    }
}

abstract class AbstractAddition<T> {
    public T result;

    abstract T add(T firstArgument, T secondArgument);
}
