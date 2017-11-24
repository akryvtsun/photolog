package org.photolog;

import java.io.*;
import java.nio.file.*;
import java.util.stream.*;

public final class JpegFileSet {
    private final Path root;

    public JpegFileSet(Path root) {
        this.root = root;
    }

    public Stream<Path> files() {
        try {
            return Files.walk(root)
                    .filter(Files::isRegularFile)
                    .filter(this::isJpeg);
        } catch (IOException e) {
            return Stream.empty();
        }
    }

    private boolean isJpeg(Path p) {
        return p.getFileSystem().getPathMatcher("glob:**/*.{jpg,jpeg}").matches(p);
    }
}
