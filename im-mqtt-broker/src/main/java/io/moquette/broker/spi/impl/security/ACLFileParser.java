/*
 */
package io.moquette.broker.spi.impl.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;

/**
 * Parses the acl configuration file.
 * If a line starts with # it's comment.
 * Blank lines are skipped. The format is "topic [read|write|readwrite] <topic name>"
 *
 * @author andrea
 * */
public class ACLFileParser {
    private static final Logger LOG = LoggerFactory.getLogger(ACLFileParser.class);

    /**
     * Parse the configuration from file.
     */
    public static AuthorizationsCollector parse(File file) throws ParseException {
        if (file == null) {
            LOG.warn("parsing NULL file, so fallback on default configuration!");
            return AuthorizationsCollector.emptyImmutableCollector();
        }
        if (!file.exists()) {
            LOG.warn(String.format("parsing not existing file %s, so fallback on default configuration!", file.getAbsolutePath()));
            return AuthorizationsCollector.emptyImmutableCollector();
        }
        try {
            FileReader reader = new FileReader(file);
            return parse(reader);
        } catch (FileNotFoundException fex) {
            LOG.warn(String.format("parsing not existing file %s, so fallback on default configuration!", file.getAbsolutePath()), fex);
            return AuthorizationsCollector.emptyImmutableCollector();
        }
    }

    /**
     * Parse the ACL configuration file
     *
     * @throws ParseException if the format is not compliant.
     */
    public static AuthorizationsCollector parse(Reader reader) throws ParseException {
        if (reader == null) {
            //just log and return default properties
            LOG.warn("parsing NULL reader, so fallback on default configuration!");
            return AuthorizationsCollector.emptyImmutableCollector();
        }

        BufferedReader br = new BufferedReader(reader);
        String line;
        AuthorizationsCollector collector = new AuthorizationsCollector();

        try {
            while ((line = br.readLine()) != null) {
                int commentMarker = line.indexOf('#');
                if (commentMarker != -1) {
                    if (commentMarker == 0) {
                        //skip its a comment
                        continue;
                    } else {
                        //it's a malformed comment
                        throw new ParseException(line, commentMarker);
                    }
                } else {
                    if (line.isEmpty() || line.matches("^\\s*$")) {
                        //skip it's a black line
                        continue;
                    }

                    collector.parse(line);
                }
            }
        } catch (IOException ex) {
            throw new ParseException("Failed to read", 1);
        }
        return collector;
    }
}
