package org.photolog;

import java.io.*;
import java.nio.file.*;

public class Application {
    private final Path root;
    private final PrintStream out;

    public Application(String root) {
        this(Paths.get(root), System.out);
    }

    Application(Path root, PrintStream out) {
        this.root = root;
        this.out = out;
    }

    public void run() throws IOException {
        new JpegFileSet(root).files()
                .map(p -> p.toUri().getPath())
                .forEach(out::println);
    }

    public static void main(String... args) throws IOException {
        new Application(args[0]).run();
    }
}
