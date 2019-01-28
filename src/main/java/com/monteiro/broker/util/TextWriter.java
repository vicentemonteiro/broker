package com.monteiro.broker.util;

import com.monteiro.broker.business.AutoBrokerService;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.stereotype.Component;

/**
 *
 * @author vicente.monteiro
 */
@Component
public class TextWriter {

    private final org.slf4j.Logger logger = getLogger(TextWriter.class);

    public void generateReport(final String text) {
        final PrintWriter writer;
        try {
            writer = new PrintWriter("report.txt", "UTF-8");
            writer.println(text);
            writer.close();
        }
        catch (final FileNotFoundException | UnsupportedEncodingException ex) {
            this.logger.error(ex.getMessage());
        }

    }
}
