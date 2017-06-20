package com.br.configproperties.loader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leonardo S. Rodrigues
 * @version 1.0
 * @since 01/05/17
 */
public class ConfigPropertiesLoader {

    private static final String PROPERTIES_NAME = "sample.properties";
    public Map<String, String> values = new HashMap<String, String>();
    Properties properties = new Properties();

    /**
     * Set key and value at map with values from properties
     *
     * @return list of elements in pairs(key and value)
     * @throws IOException if an error occurred when reading from the input
     * stream.
     */
    public Map<String, String> loadProperties() throws IOException {
        properties = getProperties(Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTIES_NAME));
        for (String value : properties.stringPropertyNames()) {
            if (!value.isEmpty() && !properties.getProperty(value).isEmpty()) {
                values.put(value, properties.getProperty(value));
            }
        }
        return values;
    }

    /**
     * Load the properties based at input stream as received.
     *
     * @param is the input stream
     * @return the properties loaded
     * @throws IOException if an error occurred when reading from the input
     */
    private Properties getProperties(InputStream is) throws IOException {
        try {
            properties.load(is);
        } catch (IllegalArgumentException e) {
            Logger.global.log(Level.SEVERE, "Properties não pode ser carregado", e);
        }
        return properties;
    }

}
