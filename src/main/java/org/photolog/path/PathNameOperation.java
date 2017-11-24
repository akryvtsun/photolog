package org.photolog.path;

import java.nio.file.*;
import java.util.function.*;

public final class PathNameOperation implements Consumer<Path> {
    private final Consumer<String> operation;

    public PathNameOperation(Consumer<String> operation) {
        this.operation = operation;
    }

    @Override
    public void accept(Path path) {
        operation.accept(path.toUri().getPath());
    }
}
