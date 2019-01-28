package com.monteiro.broker.util;

import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.Files.readAllLines;
import java.nio.file.Paths;
import static java.nio.file.Paths.get;
import java.util.logging.Logger;
import org.apache.commons.lang3.RandomStringUtils;
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
    private static final Logger LOG = Logger.getLogger(TextWriterIT.class.getName());

}
