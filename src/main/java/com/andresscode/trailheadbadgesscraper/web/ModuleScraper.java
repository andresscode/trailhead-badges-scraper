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
 * Navigates to the Modules section of Trailhead and extracts the data from every badge there.
 *
 * @see Scraper
 * @see ChromeDriver
 */
public class ModuleScraper extends ChromeDriver implements Scraper {
    public static final String URL = "https://trailhead.salesforce.com/en/modules";

    public ModuleScraper() {}

    public ModuleScraper(final ChromeOptions options) {
        super(options);
    }

    /**
     * Get the badges from the Module section
     *
     * @return A list of Module badges.
     */
    public List<Badge> getBadges() {
        List<Badge> result = new ArrayList<>();

        // Navigate to modules URL
        get(URL);

        // Getting wrappers with the name, href and duration data
        List<WebElement> wrappers = findElements(By.cssSelector("div.tile-header"));

        // Looping through all the wrappers and extracting and passing the
        // data to populate the list of badges
        wrappers.forEach(e -> result.add(new RegularBadge(
                Badge.MODULE,
                e.findElement(By.tagName("a")).getAttribute("title"),
                e.findElement(By.tagName("a")).getAttribute("href"),
                e.findElement(By.className("progress-text")).getText())));

        return result;
    }
}
