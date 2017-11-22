package org.photolog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {
    private final Path root;

    public Application(Path root) {
        this.root = root;
    }

    public void run() throws IOException {
        Files.walk(root)
                .filter(Files::isRegularFile)
                .map(p -> p.toUri().getPath())
                .forEach(System.out::println);
    }

    public static void main(String... args) throws IOException {
        new Application(
                Paths.get(args[0])
        ).run();
    }
}
