package org.photolog.path;

import com.google.common.jimfs.*;

import java.io.*;
import java.nio.file.*;

import org.junit.*;
import org.photolog.path.*;

public class JpegPathSetTest {

    @Test
    public void emptyJpegFileSet() {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path root = fs.getPath("/");
        JpegPathSet set = new JpegPathSet(root);
        Assert.assertEquals(0, set.stream().count());
    }

    @Test
    public void nonEmptyJpegFileSet() throws IOException {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path root = fs.getPath("/images");
        Files.createDirectory(root);
        Files.createFile(root.resolve("image_0.jpg"));
        Files.createFile(root.resolve("image_1.jpeg"));
        JpegPathSet set = new JpegPathSet(root);
        Assert.assertEquals(2, set.stream().count());
    }
}