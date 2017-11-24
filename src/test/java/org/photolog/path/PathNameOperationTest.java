package org.photolog.path;

import com.google.common.jimfs.*;

import java.nio.file.*;
import java.util.concurrent.atomic.*;

import org.junit.*;

public class PathNameOperationTest {

    @Test
    public void successfulOperationExecution() throws Exception {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path root = fs.getPath("/images");
        Files.createDirectory(root);
        Path path = root.resolve("0001.jpg");
        Files.createFile(path);

        final AtomicReference<String> output = new AtomicReference<>();
        new PathNameOperation(s -> output.set(s)).accept(path);

        Assert.assertEquals("/images/0001.jpg", output.get());
    }
}