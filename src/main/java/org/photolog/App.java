package org.photolog;

import java.io.File;
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
                .map(Path::toFile)
                .map(File::getAbsolutePath)
                .filter(p -> p.endsWith(".java"))
                .forEach(System.out::println);
    }
}
