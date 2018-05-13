package com.andresscode.trailheadbadgesscraper.web;

import com.andresscode.trailheadbadgesscraper.model.Badge;
import com.andresscode.trailheadbadgesscraper.model.RegularBadge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andres Martinez
 *
 * Navigates to the Modules or Projects section of Trailhead and extracts the data from every badge there.
 *
 * @see Scraper
 * @see ChromeDriver
 */
public class ScraperRegularBadge extends ChromeDriver implements Scraper {
    public static final String URL_MODULES = "https://trailhead.salesforce.com/en/modules";
    public static final String URL_PROJECTS = "https://trailhead.salesforce.com/en/projects";

    public ScraperRegularBadge() {}

    public ScraperRegularBadge(final ChromeOptions options) {
        super(options);
    }

    /**
     * Get the badges from the section in the URL.
     *
     * @return A list of regular badges.
     */
    @Override
    public List<Badge> getBadges(final String url) {
        List<Badge> result = new ArrayList<>();

        // Navigate to modules URL
        get(url);

        // Getting wrappers with the name, href and duration data
        List<WebElement> wrappers = findElements(By.cssSelector("div.tile-header"));

        // Looping through all the wrappers and extracting and passing the
        // data to populate the list of badges
        String type = (url.equals(URL_MODULES)) ? Badge.MODULE : Badge.PROJECT;
        wrappers.forEach(e -> result.add(new RegularBadge(
                type,
                e.findElement(By.tagName("a")).getAttribute("title"),
                e.findElement(By.tagName("a")).getAttribute("href"),
                e.findElement(By.className("progress-text")).getText())));

        return result;
    }
}
