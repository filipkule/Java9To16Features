package solutions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Issue2TryWithResourceStatement {

    public static void main(String[] args) {

        //try with resource statement
        try (FileOutputStream fileOutputStream = new FileOutputStream("src/main/resources/output.txt")){
            String message = "Hello stranger!";
            byte byteArray[] = message.getBytes(); //converting string into byte array
            fileOutputStream.write(byteArray);
            System.out.println("Message written to the file!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //try without resource statement inside of fetchFromResources method
            System.out.print("Read from file output.txt \n");
            System.out.print(fetchFromResources("src/main/resources/output.txt"));


    }

    private static String fetchFromResources(String fileLocation) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner;
        try {
            scanner = new Scanner(new File(fileLocation));
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

}
