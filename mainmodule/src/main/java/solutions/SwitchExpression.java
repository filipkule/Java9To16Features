import java.util.Scanner;

public class SwitchExpression {
    public static void main(String[] args) {
        System.out.println("Enter number from 1 to 7!");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();//enter number in terminal, or just hardcode this

        switch (number) {
            case 1,2,3,4,5 -> System.out.println("Working day.");
            case 6,7 -> System.out.println("Weekend!!!");
            default -> System.out.println("Invalid day");// throw exception here if needed
        }

        String result = switch (number) {
            case 1,2,3,4,5 -> "Working day.";
            case 6,7 -> "Weekend!!!";
            default -> "Invalid day";// throw exception here if needed
        };

        System.out.println(result);

        //Java 13 introduces yield
        String yieldedResult = switch (number) {
            case 1,2,3,4,5 -> {
                System.out.println("Working day.");
                yield "Working day.";
            }
            case 6,7 -> {
                System.out.println("Weekend!!!");
                yield "Weekend!!!";
            }
            default -> {
                System.out.println("Invalid day");
                yield "Invalid day";// throw exception here if needed
            }
        };

        System.out.println(yieldedResult);
    }
}
