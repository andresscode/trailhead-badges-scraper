package com.andresscode.trailheadbadgesscraper.database;

import com.andresscode.trailheadbadgesscraper.model.Badge;
import com.andresscode.trailheadbadgesscraper.web.Scraper;
import com.andresscode.trailheadbadgesscraper.web.ScraperRegularBadge;
import com.mongodb.client.result.UpdateResult;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class MongoTest {
    private Mongo db;
    private Scraper regularBadgeScraper;

    @Test
    public void mongoConstructorTest() {
        Assert.assertNotEquals(null, db);
    }

    @Test
    public void updateProjectsTest() {
        int expected = 61;
        List<Badge> badges = regularBadgeScraper.getBadges(ScraperRegularBadge.URL_PROJECTS);
        List<UpdateResult> results = db.update(badges);
        Assert.assertEquals(expected, results.size());
    }

    @Before
    public void setup() {
        Config config = new Config();
        db = new Mongo(config.getProperty("uri"), config.getProperty("database"), config.getProperty("collection"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        regularBadgeScraper = new ScraperRegularBadge(options);
    }
}
