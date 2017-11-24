package org.photolog;

import java.nio.file.*;
import java.util.function.*;

public final class PrintFileOperation implements Consumer<Path> {

    @Override
    public void accept(Path path) {
        System.out.println(path.toUri().getPath());
    }
}
