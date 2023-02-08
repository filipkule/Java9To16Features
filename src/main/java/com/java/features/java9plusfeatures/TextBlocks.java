package com.java.features.java9plusfeatures;

public class TextBlocks {
    public static void main(String[] args) {
        String source = """
        String message = "Hello, World!";
            System.out.println(message);
        """;

        String source1 = """
        String message = "Hello, World!";
            System.out.println(message);
""";

        System.out.println(source);
        System.out.println("Different indentation for the closing triple quotes, results in different output.");
        System.out.println(source1);

        String code = """
            String source = \"""
                String message = "Hello, World!";
                System.out.println(message);
                \""";
            """;// escaping triple quotes with line terminator, no need to escape single or double quotes
        System.out.println(code);

        String text = """
                Lorem ipsum dolor sit amet, consectetur adipiscing \
                elit, sed do eiusmod tempor incididunt ut labore \
                et dolore magna aliqua.\
                """;// escaping new lines with line terminator
        System.out.println(text);

        System.out.println("""
                red
                green
                blue
                """);// prints a new line at the end
        System.out.println("""
                red
                green
                blue\
                """);// no new line because of line terminator after blue
        System.out.println("""
                red
                green
                blue""");// no new line because closing triple quotes are at the same line

    }
}
