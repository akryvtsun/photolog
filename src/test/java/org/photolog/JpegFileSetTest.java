package org.photolog;

import com.google.common.jimfs.*;

import java.io.*;
import java.nio.file.*;

import org.junit.*;

public class JpegFileSetTest {

    @Test
    public void emptyJpegFileSet() {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path root = fs.getPath("/");
        JpegFileSet set = new JpegFileSet(root);
        Assert.assertEquals(0, set.files().count());
    }

    @Test
    public void nonEmptyJpegFileSet() throws IOException {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path root = fs.getPath("/images");
        Files.createDirectory(root);
        Files.createFile(root.resolve("image_0.jpg"));
        Files.createFile(root.resolve("image_1.jpeg"));
        JpegFileSet set = new JpegFileSet(root);
        Assert.assertEquals(2, set.files().count());
    }
}