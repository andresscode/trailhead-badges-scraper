package com.andresscode.trailheadbadgesscraper.model;

/**
 * @author Andres Martinez
 *
 * Type of badge that has a minimun and a maximun amount of hours.
 *
 * @see Badge
 */
public class SuperBadge extends Badge {
    private final Hour hours;

    public SuperBadge(final String type, final String name, final String href, final String duration) {
        super(type, name, href);
        this.hours = convertToHours(duration);
    }

    /**
     * Converts the duration string into an Hour object with the float value of the minimum and
     * maximum duration. The duration string has a format like this:
     *
     * - Duration: 00 hrs - 00 hrs Estimated
     *
     * The method splits the duration string into an array where the second element represents the
     * minimum hours and the fifth value in the array the maximum hours for the badge.
     *
     * @param   duration The String representing the maximum and minimum duration of each SuperBadge.
     * @return  An Hour object containing the float value of the minimum and maximum duration.
     *
     * @see Hour
     */
    private Hour convertToHours(final String duration) {
        Hour result = new Hour();

        String[] array = duration.split(" ");

        String min = array[1];
        String max = array[4];

        float minFormatted = Float.valueOf(String.format("%.2f", Float.valueOf(min)));
        float maxFormatted = Float.valueOf(String.format("%.2f", Float.valueOf(max)));

        result.setMin(minFormatted);
        result.setMax(maxFormatted);

        return result;
    }

    public Hour getHours() {
        return hours;
    }

    /**
     * Holds the data for the minimum and maximum hours.
     */
    protected class Hour {
        private float min;
        private float max;

        public Hour() {}

        public float getMin() {
            return min;
        }

        public void setMin(float min) {
            this.min = min;
        }

        public float getMax() {
            return max;
        }

        public void setMax(float max) {
            this.max = max;
        }
    }
}
