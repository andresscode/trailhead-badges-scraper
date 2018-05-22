package com.andresscode.trailheadbadgesscraper.model;

/**
 * @author Andres Martinez
 *
 * Parent object for the badges. Holds the basic information of every type of badge.
 *
 * @see RegularBadge
 * @see SuperBadge
 */
public abstract class Badge {
    // Types of badges available for scraping
    public static final String MODULE = "Module";
    public static final String PROJECT = "Project";
    public static final String SUPERBADGE = "Superbadge";

    private final String type;
    private final String name;
    private final String href;

    public Badge(final String type, final String name, final String href) {
        this.type = type;
        this.name = name;
        this.href = formatHref(href);
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }

    /**
     * Checks if the URL has a language specification like this:
     *
     * https://trailhead.salesforce.com/en/modules
     *
     * To remove it and format the URL to something like this:
     *
     * https://trailhead.salesforce.com/modules
     *
     * @param   href A string with the URL to format
     * @return  The formatted URL string
     */
    private String formatHref(final String href) {
        if (href.contains("/en/")) {
            return href.replace("/en/", "/");
        } else {
            return href;
        }
    }
}
