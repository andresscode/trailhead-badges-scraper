package com.andresscode.trailheadbadgesscraper.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SuperBadgeTest {
    private SuperBadge superBadge;

    @Test
    public void convertToHoursTest() {
        float minExpected = 1.00f;
        float maxExpected = 10.00f;
        float delta = 0.01f;
        Assert.assertEquals(minExpected, superBadge.getHours().getMin(), delta);
        Assert.assertEquals(maxExpected, superBadge.getHours().getMax(), delta);
    }

    @Test
    public void toStringTest() {
        String actual = superBadge.toString();
        String expected = String.format("SuperBadge {type: %s, name: %s, href: %s, hours: {min: %.2f, max: %.2f}}",
                superBadge.getType(), superBadge.getName(), superBadge.getHref(), superBadge.getHours().getMin(), superBadge.getHours().getMax());
        Assert.assertEquals(expected, actual);
    }

    @Before
    public void setup() {
        String type = "Type";
        String name = "Name";
        String href = "http://type/name";
        String duration = "Duration: 1 hr - 10 hrs Estimated";
        superBadge = new SuperBadge(type, name, href, duration);
    }
}
