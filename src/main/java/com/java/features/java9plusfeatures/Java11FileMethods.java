package com.java.features.java9plusfeatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Java11FileMethods {
    public static void main(String[] args) {
        try {
            Path demo = Files.createTempFile("demo", ".txt");
            Path path = Files.writeString(demo, "Sample text");
            String result = Files.readString(path);
            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
