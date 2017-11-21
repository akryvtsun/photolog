package org.photolog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {
        Path root = Paths.get("C:\\Dev\\ToDelete");
        Files.walk(root)
                .filter(Files::isRegularFile)
                .forEach(System.out::println);
    }
}
