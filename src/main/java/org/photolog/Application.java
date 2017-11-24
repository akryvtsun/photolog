package org.photolog;

import java.io.*;
import java.nio.file.*;
import java.util.function.*;

import org.photolog.path.*;

public final class Application {
    private final JpegPathSet pathSet;
    private final Consumer<Path> operation;

    public Application(Path root, Consumer<String> printFunc) {
        pathSet = new JpegPathSet(root);
        operation = new PathNameOperation(printFunc);
    }

    public void run() throws IOException {
        pathSet.stream()
            .forEach(operation);
    }

    public static void main(String... args) throws IOException {
        new Application(
                Paths.get(args[0]), System.out::println
        ).run();
    }
}
