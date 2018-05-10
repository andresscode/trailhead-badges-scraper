package com.andresscode.trailheadbadgesscraper.web;

import com.andresscode.trailheadbadgesscraper.model.Badge;

import java.util.List;

/**
 * @author Andres Martinez
 *
 * Returns a list of Badges from a specific URL.
 *
 * @see ScraperRegularBadge
 */
public interface Scraper {

    /**
     * Get the badges from a specific URL.
     *
     * @param url String containing the URL to scrap
     *
     * @return A list of badges.
     */
    List<Badge> getBadges(final String url);
}
