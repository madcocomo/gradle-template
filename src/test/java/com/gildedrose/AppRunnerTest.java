package com.gildedrose;

import com.google.common.base.Charsets;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class AppRunnerTest {
    @Test
    public void safeNetTest() throws URISyntaxException, IOException {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        AppRunner.main(new String[]{getClass().getResource("/items.txt").getPath(), "6"});
        byte[] bytes = Files.readAllBytes(Paths.get(getClass().getResource("/expected.txt").toURI()));
        String expected = new String(bytes, Charsets.UTF_8);
        assertEquals(expected, out.toString());
    }
}
