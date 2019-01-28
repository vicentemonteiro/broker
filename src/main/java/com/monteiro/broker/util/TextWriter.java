package com.monteiro.broker.util;

import com.monteiro.broker.business.AutoBrokerService;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import static org.slf4j.LoggerFactory.getLogger;
import org.springframework.stereotype.Component;

/**
 *
 * @author vicente.monteiro
 */
@Component
public class TextWriter {

    private final org.slf4j.Logger logger = getLogger(AutoBrokerService.class);

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
    private static final Logger LOG = Logger.getLogger(TextWriter.class.getName());
}
