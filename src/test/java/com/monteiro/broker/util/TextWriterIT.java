package com.monteiro.broker.util;

import java.io.IOException;
import static java.nio.file.Files.readAllLines;
import static java.nio.file.Paths.get;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Administrator
 */
public class TextWriterIT {

    @Test
    public void testGenerateReport() throws IOException {
        final String str = randomAlphabetic(5);
        new TextWriter().generateReport(str);
        assertTrue(readAllLines(get("report.txt")).contains(str));
    }

}
