package com.andresscode.trailheadbadgesscraper.web;

import com.andresscode.trailheadbadgesscraper.model.Badge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class ModuleScraperTest {
    private ModuleScraper scraper;

    @Test
    public void getBadgesTest() {
        int expected = 327;
        List<Badge> badges = scraper.getBadges();
        Assert.assertEquals(expected, badges.size());
    }

    @Test
    public void constructorTest() {
        ModuleScraper scraperWithHead = new ModuleScraper();
        scraperWithHead.close();
        Assert.assertNotEquals(null, scraperWithHead);
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        scraper = new ModuleScraper(options);
    }
}
