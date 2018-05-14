package com.andresscode.trailheadbadgesscraper.database;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Andres Martinez
 *
 * Returns the data contained in the config.cfg file.
 *
 * @see Properties
 */
public class Config {
    private Properties properties;

    public Config() {
        this.properties = new Properties();
        try {
            this.properties.load(this.getClass().getClassLoader().getResourceAsStream("config.cfg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the value of a property stored in the config.cfg file.
     *
     * @param key The property Key
     * @return The property value
     */
    public String getProperty(final String key) {
        return this.properties.getProperty(key);
    }
}
