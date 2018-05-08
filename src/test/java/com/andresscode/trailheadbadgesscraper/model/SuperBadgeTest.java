package com.andresscode.trailheadbadgesscraper.model;

import org.junit.Assert;
import org.junit.Test;

public class SuperBadgeTest {
    @Test
    public void convertToHoursTest() {
        String type = "Type";
        String name = "Name";
        String href = "http://type/name";
        String duration = "Duration: 1 hr - 10 hrs Estimated";
        SuperBadge superBadge = new SuperBadge(type, name, href, duration);
        float minExpected = 1.00f;
        float maxExpected = 10.00f;
        float delta = 0.01f;
        Assert.assertEquals(minExpected, superBadge.getHours().get(SuperBadge.MIN_HOURS), delta);
        Assert.assertEquals(maxExpected, superBadge.getHours().get(SuperBadge.MAX_HOURS), delta);
    }
}
