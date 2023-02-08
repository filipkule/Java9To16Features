package com.java.features.java9plusfeatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMismatchMethod {
    public static void main(String[] args) throws IOException {
        Path path1 = Files.createTempFile("file1", ".txt");
        Path path2 = Files.createTempFile("file2", ".txt");
        Files.writeString(path1, "Hello Stranger!");
        Files.writeString(path2, "Hello Stranger!");
        long mismatchSameContent = Files.mismatch(path1, path2);
        System.out.println(mismatchSameContent);// returns -1 because content of both files matches

        Path path3 = Files.createTempFile("file3", ".txt");
        Path path4 = Files.createTempFile("file4", ".txt");
        Files.writeString(path3, "Hello Stranger!");
        Files.writeString(path4, "Hello User!");
        long mismatchDifferentContent = Files.mismatch(path3, path4);// returns 6 because the first difference appears at the sixth byte
        System.out.println(mismatchDifferentContent);
    }
}
