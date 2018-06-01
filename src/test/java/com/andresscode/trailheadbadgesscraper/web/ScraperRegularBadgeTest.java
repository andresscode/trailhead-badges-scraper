package com.andresscode.trailheadbadgesscraper.web;

import com.andresscode.trailheadbadgesscraper.model.Badge;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class ScraperRegularBadgeTest {
    private ScraperRegularBadge scraper;

    @Test
    public void getBadgesFromModulesTest() {
        int expected = 335;
        List<Badge> badges = scraper.getBadges(ScraperRegularBadge.URL_MODULES);
        Assert.assertEquals(expected, badges.size());
    }

    @Test
    public void getBadgesFromProjectsTest() {
        int expected = 66;
        List<Badge> badges = scraper.getBadges(ScraperRegularBadge.URL_PROJECTS);
        Assert.assertEquals(expected, badges.size());
    }

    @Test
    public void constructorTest() {
        ScraperRegularBadge scraperWithHead = new ScraperRegularBadge();
        scraperWithHead.close();
        Assert.assertNotEquals(null, scraperWithHead);
    }

    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        scraper = new ScraperRegularBadge(options);
    }
}
