package com.andresscode.trailheadbadgesscraper.model;

/**
 * @author Andres Martinez
 *
 * Parent object for the badges. Holds the basic information of every type of badge.
 *
 * @see RegularBadge
 * @see SuperBadge
 */
public class Badge {
    private final String type;
    private final String name;
    private final String href;

    public Badge(final String type, final String name, final String href) {
        this.type = type;
        this.name = name;
        this.href = href;
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
}
