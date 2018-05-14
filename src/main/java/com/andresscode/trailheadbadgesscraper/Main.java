package com.andresscode.trailheadbadgesscraper;

import com.andresscode.trailheadbadgesscraper.database.Mongo;
import com.andresscode.trailheadbadgesscraper.model.Badge;
import com.andresscode.trailheadbadgesscraper.web.Scraper;
import com.andresscode.trailheadbadgesscraper.web.ScraperRegularBadge;
import com.andresscode.trailheadbadgesscraper.web.ScraperSuperBadge;
import com.mongodb.client.result.UpdateResult;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initialising application");

        // Setting ChromeDriver options
        System.out.println("Setting up ChromeDriver options");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");

        // Scraping Modules and Projects
        System.out.println("Initialising regular badges scraper");
        Scraper regularBadgesScraper = new ScraperRegularBadge(options);
        System.out.println("Scraping Modules...");
        List<Badge> modules = regularBadgesScraper.getBadges(ScraperRegularBadge.URL_MODULES);
        System.out.println("Scraping Projects...");
        List<Badge> projects = regularBadgesScraper.getBadges(ScraperRegularBadge.URL_PROJECTS);
        System.out.println("Closing regular badges scraper");
        ((ScraperRegularBadge) regularBadgesScraper).quit();

        // Scraping super badges
        System.out.println("Initialising super badges scraper");
        Scraper superBadgesScraper = new ScraperSuperBadge(10, options);
        System.out.println("Scraping super badges...");
        List<Badge> superBadges = superBadgesScraper.getBadges(ScraperSuperBadge.URL_SUPERBADGES);
        System.out.println("Closing super badges scraper");
        ((ScraperSuperBadge) superBadgesScraper).quit();

        // Updating database
        System.out.println("Initialising database");
        Mongo db = new Mongo();

        System.out.println("Updating Modules");
        List<UpdateResult> resultModules = db.update(modules);
        resultModules.forEach(System.out::println);
        System.out.println(String.format("%d Modules updated", resultModules.size()));

        System.out.println("Updating Projects");
        List<UpdateResult> resultProjects = db.update(projects);
        resultProjects.forEach(System.out::println);
        System.out.println(String.format("%d Projects updated", resultProjects.size()));

        System.out.println("Updating SuperBadges");
        List<UpdateResult> resultSuperBadges = db.update(superBadges);
        resultSuperBadges.forEach(System.out::println);
        System.out.println(String.format("%d SuperBadges updated", resultSuperBadges.size()));

        // Closing database connection
        System.out.println("Closing database connection");
        db.close();

        // Exit
        System.out.println("Process completed");
        System.out.println(String.format("%d badges updated", resultModules.size() + resultProjects.size() + resultSuperBadges.size()));
    }
}
