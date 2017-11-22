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
        Files.walk(root)
                .filter(Files::isRegularFile)
                .filter(this::isJpeg)
                .map(p -> p.toUri().getPath())
                .forEach(out::println);
    }

    private boolean isJpeg(Path p) {
        return p.getFileSystem().getPathMatcher("regex:.+(jpg|jpeg)$").matches(p);
    }

    public static void main(String... args) throws IOException {
        new Application(args[0]).run();
    }
}
