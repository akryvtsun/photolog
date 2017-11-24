package org.photolog;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public final class JpegFileSet {
    private final Path root;
    private final JpegPathMatcher matcher;

    public JpegFileSet(Path root) {
        this.root = root;
        matcher = new JpegPathMatcher(root);
    }

    public Stream<Path> files() {
        try {
            return Files.walk(root)
                    .filter(Files::isRegularFile)
                    .filter(matcher);
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}
