package com.andresscode.trailheadbadgesscraper.web;

import com.andresscode.trailheadbadgesscraper.model.Badge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class ScraperSuperBadgeTest {
    private ScraperSuperBadge scraper;

    @Test
    public void getBadgesFromSuperBadgesTest() {
        int expected = 12;
        List<Badge> badges = scraper.getBadges(ScraperSuperBadge.URL_SUPERBADGES);
        Assert.assertEquals(expected, badges.size());
    }

    @Test
    public void constructorTest() {
        ScraperSuperBadge scraperWithHead = new ScraperSuperBadge(10);
        scraperWithHead.close();
        Assert.assertNotEquals(null, scraperWithHead);
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        scraper = new ScraperSuperBadge(10, options);
    }
}
