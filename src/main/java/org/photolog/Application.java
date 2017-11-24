package org.photolog;

import java.io.*;
import java.nio.file.*;
import java.util.function.*;

import org.photolog.path.*;

public class Application {
    private final JpegPathSet pathSet;
    private final Consumer<Path> operation;

    public Application(String root) {
        this(Paths.get(root), new PathNameOperation(System.out::println));
    }

    Application(Path root, Consumer<Path> operation) {
        pathSet = new JpegPathSet(root);
        this.operation = operation;
    }

    public void run() throws IOException {
        pathSet.stream()
            .forEach(operation);
    }

    public static void main(String... args) throws IOException {
        new Application(args[0]).run();
    }
}
