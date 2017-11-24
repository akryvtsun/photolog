package org.photolog.path;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public final class JpegPathSet {
    private final Path root;
    private final JpegPathMatcher matcher;

    public JpegPathSet(Path root) {
        this.root = root;
        matcher = new JpegPathMatcher(root);
    }

    public Stream<Path> stream() {
        try {
            return Files.walk(root)
                    .filter(Files::isRegularFile)
                    .filter(matcher);
        } catch (IOException e) {
            return Stream.empty();
        }
    }
}
