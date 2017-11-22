package org.photolog;

import com.google.common.collect.*;
import com.google.common.jimfs.*;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

import org.junit.*;

public class ApplicationTest {

    @Test
    public void successfulRun() throws IOException {
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path foo = fs.getPath("/foo");
        Files.createDirectory(foo);

        Path hello = foo.resolve("hello.txt");
        Files.write(hello, ImmutableList.of("hello world"), StandardCharsets.UTF_8);

        new Application(foo).run();
    }

}
