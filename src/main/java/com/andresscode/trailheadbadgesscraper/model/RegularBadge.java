package com.andresscode.trailheadbadgesscraper.model;

/**
 * @author Andres Martinez
 *
 * Type of badge that has a single amount of hours.
 *
 * @see Badge
 */
public class RegularBadge extends Badge {
    private final float hours;

    public RegularBadge(final String type, final String name, final String href, final String duration) {
        super(type, name, href);
        this.hours = convertToHours(duration);
    }

    /**
     * Converts the duration string into a float number representing the hours of the badges duration. The
     * string could be in one of the next three formats:
     *
     * - 00 min[s]
     * - 00 hr[s]
     * - 00 hr[s] 00 min[s]
     *
     * The method splits the duration string and checks if the string contains hours and minutes or, just
     * hours or, just minutes. Then converts the values to hours (minutes are divided by 60 to get the
     * value in hours).
     *
     * @param   duration The String representing the time in hours and/or minutes of each badge.
     * @return  A Float number representing the duration in hours.
     */
    private static float convertToHours(final String duration) {
        float result = 0;

        // The duration is divided by white spaces
        String[] array = duration.split(" ");
        int len = array.length;

        // The first value always will be a digit
        float firstDigit = Float.valueOf(array[0]);

        // When is just 00 hr[s] or 00 min[s]
        if (len == 2) {
            if (array[1].contains("hr")) {
                result = firstDigit;
            } else {
                // If is min[s] must be divided by 60
                // to get the value in hours
                result = firstDigit / 60f;
            }
        }
        // When is 00 hr[s] 00 min[s]
        if (len == 4) {
            result = firstDigit + (Float.valueOf(array[2]) / 60f);
        }

        // Formatting the float to contain 2 decimals
        return Float.valueOf(String.format("%.2f", result));
    }

    public float getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return String.format("RegularBadge {type: %s, name: %s, href: %s, hours: %.2f}",
                this.getType(), this.getName(), this.getHref(), this.getHours());
    }
}
