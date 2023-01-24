public class SafeVarargsAnnotation {
    public static void main(String[] args) {
        printAllArgs("Hello ", "Stranger!");
    }

    @SafeVarargs
    private static void printAllArgs(String... inputArgs){
        for (String argument: inputArgs) {
            System.out.print(argument);
        }
    }
}
