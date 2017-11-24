package org.photolog;

import java.io.*;
import java.nio.file.*;
import java.util.function.*;

public class Application {
    private final JpegFileSet fileSet;
    private final Consumer<Path> operation;

    public Application(String root) {
        this(Paths.get(root), new PrintFileOperation());
    }

    Application(Path root, Consumer<Path> operation) {
        fileSet = new JpegFileSet(root);
        this.operation = operation;
    }

    public void run() throws IOException {
        fileSet.files()
            .forEach(operation);
    }

    public static void main(String... args) throws IOException {
        new Application(args[0]).run();
    }
}
