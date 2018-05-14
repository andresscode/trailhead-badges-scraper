package com.andresscode.trailheadbadgesscraper.database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigTest {
    private Config config;

    @Test
    public void constructorTest() {
        Assert.assertNotEquals(null, config);
    }

    @Test
    public void getPropertyTest() {
        String expected = "test";
        Assert.assertEquals(expected, config.getProperty("test"));
    }

    @Before
    public void setup() {
        this.config = new Config();
    }
}
