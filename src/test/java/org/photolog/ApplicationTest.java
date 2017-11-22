package org.photolog;

import com.google.common.jimfs.*;

import java.io.*;
import java.nio.file.*;

import org.junit.*;

public class ApplicationTest {

    @Test
    public void successfulRun() throws IOException {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());

        // root
        Path root = fs.getPath("/root");
        Files.createDirectory(root);
        // images
        Path images = fs.getPath("/root/images");
        Files.createDirectory(images);
        Files.createFile(images.resolve("image_0.jpg"));
        Files.createFile(images.resolve("image_1.jpeg"));
        // docs
        Path docs = fs.getPath("/root/docs");
        Files.createDirectory(docs);
        Files.createFile(docs.resolve("doc.txt"));

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        new Application(root, new PrintStream(stream)).run();

        Assert.assertEquals(2, stream.toString().split(System.lineSeparator()).length);
    }
}
