package org.smartequip.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.smartequip.application.Main;

import java.io.IOException;
import java.io.InputStream;

public class DataLoader {

    private DataLoader() {
        throw new IllegalStateException("Utility class");
    }
    public static <T> T parseJson(final String file, final Class<T> classToParseContent) throws IOException {
        try(final InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(file)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("File not found in resources folder");
            }
            return new ObjectMapper().readValue(inputStream, classToParseContent);
        } catch (Exception exception) {
            System.err.println("Error while reading and parsing json file: " + exception);
            throw exception;
        }
    }
}
