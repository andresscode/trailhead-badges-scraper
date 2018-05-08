package com.andresscode.trailheadbadgesscraper.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Andres Martinez
 *
 * Type of badge that has a minimun and a maximun amount of hours.
 *
 * @see Badge
 */
public class SuperBadge extends Badge {
    public static final String MIN_HOURS = "min";
    public static final String MAX_HOURS = "max";

    private final Map<String, Float> hours;

    public SuperBadge(final String type, final String name, final String href, final String duration) {
        super(type, name, href);
        this.hours = convertToHours(duration);
    }

    /**
     * Converts the duration string into a map (min and max) with the float value of each one.
     * The duration string has a format like this:
     *
     * - Duration: 00 hrs - 00 hrs Estimated
     *
     * The method splits the duration string into an array where the second element represents the
     * minimum hours and the fifth value in the array the maximum hours for the badge.
     *
     * @param   duration The String representing the maximum and minimum duration of each SuperBadge.
     * @return  A Map containing the float value of the minimum and maximum duration.
     */
    private Map<String, Float> convertToHours(final String duration) {
        Map<String, Float> result = new HashMap<String, Float>();

        String[] array = duration.split(" ");

        String min = array[1];
        String max = array[4];

        float minFormatted = Float.valueOf(String.format("%.2f", Float.valueOf(min)));
        float maxFormatted = Float.valueOf(String.format("%.2f", Float.valueOf(max)));

        result.put(MIN_HOURS, minFormatted);
        result.put(MAX_HOURS, maxFormatted);

        return result;
    }

    public Map<String, Float> getHours() {
        return hours;
    }
}
