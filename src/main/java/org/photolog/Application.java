package org.photolog;

import java.io.*;
import java.nio.file.*;
import java.util.function.*;

public class Application {
    private final Path root;
    private final Consumer<String> processor;

    public Application(String root) {
        this(Paths.get(root), System.out::println);
    }

    Application(Path root, Consumer<String> processor) {
        this.root = root;
        this.processor = processor;
    }

    public void run() throws IOException {
        new JpegFileSet(root).files()
                .map(p -> p.toUri().getPath())
                .forEach(processor);
    }

    public static void main(String... args) throws IOException {
        new Application(args[0]).run();
    }
}
