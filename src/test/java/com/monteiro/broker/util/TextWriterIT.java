package com.monteiro.broker.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.commons.lang3.RandomStringUtils;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class TextWriterIT {

    @Test
    public void testGenerateReport() throws IOException {
        final String str = RandomStringUtils.randomAlphabetic(5);
        new TextWriter().generateReport(str);
        assertTrue(Files.readAllLines(Paths.get("report.txt")).contains(str));
    }

}
