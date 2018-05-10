package com.andresscode.trailheadbadgesscraper.web;

import com.andresscode.trailheadbadgesscraper.model.Badge;
import com.andresscode.trailheadbadgesscraper.model.SuperBadge;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andres Martinez
 *
 * Navigates to the Super Badges section of Trailhead and extracts the data from every badge there.
 *
 * @see ChromeDriver
 * @see Scraper
 */
public class ScraperSuperBadge extends ChromeDriver implements Scraper {
    public static final String URL_SUPERBADGES = "https://trailhead.salesforce.com/en/superbadges";

    private WebDriverWait wait;

    public ScraperSuperBadge(final int waitTimeout) {
        this.wait = new WebDriverWait(this, waitTimeout);
    }

    public ScraperSuperBadge(final int waitTimeout, final ChromeOptions options) {
        super(options);
        this.wait = new WebDriverWait(this, waitTimeout);
    }

    /**
     * Get the super badges from the section in the URL.
     *
     * @param url String containing the URL to scrap
     *
     * @return A list of super badges
     */
    @Override
    public List<Badge> getBadges(final String url) {
        List<Badge> badges = new ArrayList<>();

        get(url);

        // Getting the badges anchors
        List<WebElement> superBadgesAnchors = findElements(By.cssSelector("a[class=tile-title]"));

        List<String> linksText = new ArrayList<>();

        // Extracting the link texts to iterate
        for (WebElement e : superBadgesAnchors) {
            linksText.add(e.getText());
        }

        // Iterating over every badge anchor
        for (String s : linksText) {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText(s)));
            String href = link.getAttribute("href");
            link.click();
            WebElement durationText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h5[contains(text(),'Duration')]")));
            badges.add(new SuperBadge(Badge.SUPERBADGE, s, href, durationText.getText()));
            navigate().back();
        }

        return badges;
    }
}
